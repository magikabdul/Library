package com.kodilla.cholewa.library.repository;

import com.kodilla.cholewa.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;

public interface ReaderRepository extends CrudRepository<Reader, Long> {

    Reader save(Reader reader);

    void deleteById(Long readerId);

    Reader getReaderById(Long readerId);
}
