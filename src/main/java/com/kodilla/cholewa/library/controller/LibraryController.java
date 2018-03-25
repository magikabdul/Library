package com.kodilla.cholewa.library.controller;

import com.kodilla.cholewa.library.domain.copies.Copy;
import com.kodilla.cholewa.library.domain.copies.CopyDto;
import com.kodilla.cholewa.library.domain.readers.Reader;
import com.kodilla.cholewa.library.domain.readers.ReaderDto;
import com.kodilla.cholewa.library.domain.rents.Rent;
import com.kodilla.cholewa.library.domain.rents.RentDto;
import com.kodilla.cholewa.library.domain.titles.Title;
import com.kodilla.cholewa.library.domain.titles.TitleDto;
import com.kodilla.cholewa.library.expeptions.CopyNotFoundException;
import com.kodilla.cholewa.library.expeptions.ReaderNotFoundException;
import com.kodilla.cholewa.library.expeptions.RentNotFoundException;
import com.kodilla.cholewa.library.expeptions.TitleNotFoundException;
import com.kodilla.cholewa.library.mapper.CopyMapper;
import com.kodilla.cholewa.library.mapper.ReaderMapper;
import com.kodilla.cholewa.library.mapper.RentMapper;
import com.kodilla.cholewa.library.mapper.TitleMapper;
import com.kodilla.cholewa.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1")
public class LibraryController {

    @Autowired
    private DbService service;

    @Autowired
    private ReaderMapper readerMapper;

    @Autowired
    private TitleMapper titleMapper;

    @Autowired
    private CopyMapper copyMapper;

    @Autowired
    private RentMapper rentMapper;


    @RequestMapping(method = RequestMethod.POST, value = "/readers")
    public void addReader(@RequestBody ReaderDto readerDto) {
        service.saveReader(readerMapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/readers/{readerId}")
    public ReaderDto findReaderById(@PathVariable Long readerId) throws ReaderNotFoundException {
        return readerMapper.mapToReaderDto(service.getReader(readerId)
                .orElseThrow(() -> new ReaderNotFoundException("Reader doesn't exist in data base")));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/titles")
    public void addTitle(@RequestBody TitleDto titleDto) {
        service.saveTitle(titleMapper.mapToTitle(titleDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/titles/{titleId}")
    public TitleDto findTitleById(@PathVariable Long titleId) throws TitleNotFoundException{
        return titleMapper.mapToTitleDto(service.getTitle(titleId)
                .orElseThrow(() -> new TitleNotFoundException("Title doesn't exist in data base")));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/copies/title/{titleId}")
    public void addCopy(@PathVariable Long titleId) throws TitleNotFoundException{
        Title title = service.getTitle(titleId)
                .orElseThrow(() -> new TitleNotFoundException("Title doesn't exist in data base"));
        service.saveCopy(copyMapper.mapToCopy(title));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/copies")
    public void updateCopyStatus(@RequestBody CopyDto copyDto) throws CopyNotFoundException {
        Copy copy = service.getCopy(copyDto.getId())
                .orElseThrow(() -> new CopyNotFoundException("Copy doesn't exist in data base"));
        copy.setStatus(copyDto.getStatus());
        service.saveCopy(copy);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/copies/{copyId}")
    public CopyDto findCopyById(@PathVariable Long copyId) throws CopyNotFoundException{
        return copyMapper.mapToCopyDto(service.getCopy(copyId)
                .orElseThrow(() -> new CopyNotFoundException("Copy doesn't exist in data base")));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getQuantityOfAvailableCopies/title/{titleId}")
    public int getQuantityOfCopiesAvailableToRent(@PathVariable Long titleId) {
        return service.countAvailableCopies(titleId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rents/title/{titleId}/reader/{readerId}")
    public RentDto rentCopy(@PathVariable Long titleId, @PathVariable Long readerId) throws ReaderNotFoundException, CopyNotFoundException {
        Reader reader = service.getReader(readerId)
                .orElseThrow(() -> new ReaderNotFoundException("Reader doesn't exist in data base"));

        Copy copy = service.findAvailableTitleCopy(titleId)
                .orElseThrow(() -> new CopyNotFoundException("Can't find available copy of title with id: " + titleId));
        copy.setStatus(Copy.STATUS_IN_USE);
        service.saveCopy(copy);
        return rentMapper.mapToRentDto(service.saveRent(rentMapper.createRent(reader, copy)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rents/{rentId}")
    private RentDto getRentById(@PathVariable Long rentId) throws RentNotFoundException{
        return rentMapper.mapToRentDto(service.getRent(rentId)
                .orElseThrow(() -> new RentNotFoundException("Rent doesn't exist in data base")));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/rents/{rentId}")
    public RentDto returnCopy(@PathVariable Long rentId) throws RentNotFoundException{
        Rent rent = service.getRent(rentId)
                .orElseThrow(() -> new RentNotFoundException("Rent doesn't exist in data base"));
        rent.setReturnDate(new Date());
        return rentMapper.mapToRentDto(service.saveRent(rent));
    }
}
