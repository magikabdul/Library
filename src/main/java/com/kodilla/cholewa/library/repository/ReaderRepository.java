package com.kodilla.cholewa.library.repository;

import com.kodilla.cholewa.library.domain.readers.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public interface ReaderRepository extends CrudRepository<Reader, Long> {

    Reader save(Reader reader);

    void deleteById(Long readerId);

    Reader getReaderById(Long readerId);
}
