package com.kodilla.cholewa.library.repository;

import com.kodilla.cholewa.library.domain.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {
    @Autowired
    private ReaderRepository readerRepository;

    public Reader saveReader(final Reader reader) {
        return readerRepository.save(reader);
    }

    public void deleteReader(final Long readerId) {
        readerRepository.deleteById(readerId);
    }

    public Reader getReader(final Long readerId) {
        return readerRepository.getReaderById(readerId);
    }
}
