package com.kodilla.cholewa.library.mapper;

import com.kodilla.cholewa.library.domain.readers.Reader;
import com.kodilla.cholewa.library.domain.readers.ReaderDto;
import org.springframework.stereotype.Component;

@Component
public class ReaderMapper {

    public ReaderDto mapToReaderDto(Reader reader) {
        return new ReaderDto(reader.getId(),
                reader.getFirstName(),
                reader.getLastName(),
                reader.getCreated());
    }

    public Reader mapToReader(ReaderDto readerDto) {
        return new Reader(
                readerDto.getFirstName(),
                readerDto.getLastName());
    }
}
