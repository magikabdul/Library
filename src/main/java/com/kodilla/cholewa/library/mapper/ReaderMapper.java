package com.kodilla.cholewa.library.mapper;

import com.kodilla.cholewa.library.domain.Reader;
import com.kodilla.cholewa.library.domain.ReaderDto;
import org.springframework.stereotype.Component;

@Component
public class ReaderMapper {

    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getId(),
                readerDto.getFirstName(),
                readerDto.getLastName(),
                readerDto.getCreated());
    }
}
