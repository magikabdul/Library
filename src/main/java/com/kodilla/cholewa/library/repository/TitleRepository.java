package com.kodilla.cholewa.library.repository;

import com.kodilla.cholewa.library.domain.titles.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public interface TitleRepository extends CrudRepository<Title, Long> {

    Title getTitleById(Long titleId);
}
