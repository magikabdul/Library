package com.kodilla.cholewa.library.domain.rents;

import com.kodilla.cholewa.library.domain.copies.CopyDto;
import com.kodilla.cholewa.library.domain.readers.ReaderDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class RentDto {
    private Long id;
    private ReaderDto readerDto;
    private CopyDto copyDto;
    private Date rentDate;
    private Date returnDate;
}
