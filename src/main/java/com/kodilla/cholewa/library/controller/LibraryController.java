package com.kodilla.cholewa.library.controller;

import com.kodilla.cholewa.library.domain.copies.Copy;
import com.kodilla.cholewa.library.domain.copies.CopyDto;
import com.kodilla.cholewa.library.domain.readers.ReaderDto;
import com.kodilla.cholewa.library.domain.titles.Title;
import com.kodilla.cholewa.library.domain.titles.TitleDto;
import com.kodilla.cholewa.library.mapper.CopyMapper;
import com.kodilla.cholewa.library.mapper.ReaderMapper;
import com.kodilla.cholewa.library.mapper.RentMapper;
import com.kodilla.cholewa.library.mapper.TitleMapper;
import com.kodilla.cholewa.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST, value = "/titles")
    public void addTitle(@RequestBody TitleDto titleDto) {
        service.saveTitle(titleMapper.mapToTitle(titleDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/copies/title/{titleId}")
    public void addCopy(@PathVariable Long titleId) {
        Title title = service.getTitle(titleId);
        service.saveCopy(copyMapper.mapToCopy(title));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/copies")
    public void updateCopyStatus(@RequestBody CopyDto copyDto) {
        Copy copy = service.getCopy(copyDto.getId());
        copy.setStatus(copyDto.getStatus());
        service.saveCopy(copy);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getQuantityOfAvailableCopies")
    public int getQuantityOfCopiesAvailableToRent(@RequestBody TitleDto titleDto) {
        return 0;
    }

//    @RequestMapping(method = RequestMethod.PUT, value = "rentCopy")
//    public boolean rentCopy(@RequestBody TitleDto titleDto) {
//        return false;
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, value = "returnCopy")
//    public boolean returnCopy(@RequestBody TitleDto titleDto) {
//        return false;
//    }
}
