package com.kodilla.cholewa.library.repository;

import com.kodilla.cholewa.library.domain.readers.Reader;
import com.kodilla.cholewa.library.domain.titles.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {
    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private TitleRepository titleRepository;

    public Reader saveReader(final Reader reader) {
        return readerRepository.save(reader);
    }

    public void deleteReader(final Long readerId) {
        readerRepository.deleteById(readerId);
    }

    public Reader getReader(final Long readerId) {
        return readerRepository.getReaderById(readerId);
    }

    public Title saveTitle(final Title title) {
        return titleRepository.save(title);
    }

    public void deleteTitle(final Long titleId) {
        titleRepository.deleteById(titleId);
    }

    public Title getTitle(final Long titleId) {
        return titleRepository.getTitleById(titleId);
    }
}
