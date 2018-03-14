package com.kodilla.cholewa.library.repository;

import com.kodilla.cholewa.library.domain.rents.Rent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Transactional
@Component
public interface RentRepository extends CrudRepository<Rent, Long> {

    Rent getRentById(Long Id);
}
