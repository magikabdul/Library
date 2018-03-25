package com.kodilla.cholewa.library.repository;

import com.kodilla.cholewa.library.domain.titles.Title;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public interface TitleRepository extends CrudRepository<Title, Long> {

    Optional<Title> getTitleById(Long titleId);

    @Query(nativeQuery = true)
    List<Title> getAllTitles();
}
