package com.kodilla.cholewa.library.repository;

import com.kodilla.cholewa.library.domain.copies.Copy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CopyRepository extends CrudRepository<Copy, Long> {

    //Copy save(Copy copy);

    void deleteById(Long id);

    Copy getCopyById(Long id);
}
