package com.kodilla.cholewa.library.service;

import com.kodilla.cholewa.library.domain.copies.Copy;
import com.kodilla.cholewa.library.domain.readers.Reader;
import com.kodilla.cholewa.library.domain.rents.Rent;
import com.kodilla.cholewa.library.domain.titles.Title;
import com.kodilla.cholewa.library.repository.CopyRepository;
import com.kodilla.cholewa.library.repository.ReaderRepository;
import com.kodilla.cholewa.library.repository.RentRepository;
import com.kodilla.cholewa.library.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private CopyRepository copyRepository;

    @Autowired
    private RentRepository rentRepository;

    public Reader saveReader(final Reader reader) {
        return readerRepository.save(reader);
    }

    public void deleteReader(final Long readerId) {
        readerRepository.deleteById(readerId);
    }

    public Optional<Reader> getReader(final Long readerId) {
        return readerRepository.getReaderById(readerId);
    }

    public Title saveTitle(final Title title) {
        return titleRepository.save(title);
    }

    public void deleteTitle(final Long titleId) {
        titleRepository.deleteById(titleId);
    }

    public Optional<Title> getTitle(final Long titleId) {
        return titleRepository.getTitleById(titleId);
    }

    public List<Title> getAllTitles() {
        return titleRepository.getAllTitles();
    }

    public Copy saveCopy(final Copy copy) {
        return copyRepository.save(copy);
    }

    public void deleteCopy(final Long copyId) {
        copyRepository.deleteById(copyId);
    }

    public Optional<Copy> getCopy(final Long copyId) {
        return copyRepository.getCopyById(copyId);
    }

    public int countAvailableCopies(Long titleId) {
        return copyRepository.countTitlesWithStatus(Copy.STATUS_AVAILABLE, titleId);
    }

    public Optional<Copy> findAvailableTitleCopy(Long titleId) {
        return copyRepository.findByStatusAndTitleId(Copy.STATUS_AVAILABLE, titleId);
    }

    public Rent saveRent(final Rent rent) {
        return rentRepository.save(rent);
    }

    public void deleteRent(final Long rentId) {
        rentRepository.deleteById(rentId);
    }

    public Optional<Rent> getRent(final Long rentId) {
        return rentRepository.getRentById(rentId);
    }
}
