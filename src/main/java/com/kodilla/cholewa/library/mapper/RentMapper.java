package com.kodilla.cholewa.library.mapper;

import com.kodilla.cholewa.library.domain.copies.Copy;
import com.kodilla.cholewa.library.domain.readers.Reader;
import com.kodilla.cholewa.library.domain.rents.Rent;
import com.kodilla.cholewa.library.domain.rents.RentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RentMapper {

    @Autowired
    private ReaderMapper readerMapper;

    @Autowired
    private CopyMapper copyMapper;

    public RentDto mapToRentDto(Rent rent) {
        return new RentDto(rent.getId(),
                readerMapper.mapToReaderDto(rent.getReader()),
                copyMapper.mapToCopyDto(rent.getCopy()),
                rent.getRentDate(),
                rent.getReturnDate()
        );
    }
    public Rent createRent(Reader reader, Copy copy) {
        return new Rent(new Date(), reader, copy);
    }
}
