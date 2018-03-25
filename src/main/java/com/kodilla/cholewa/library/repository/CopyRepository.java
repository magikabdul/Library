package com.kodilla.cholewa.library.repository;

import com.kodilla.cholewa.library.domain.copies.Copy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface CopyRepository extends CrudRepository<Copy, Long> {

    Optional<Copy> getCopyById(Long id);

    @Query(nativeQuery = true)
    int countTitlesWithStatus(@Param("copy_status") String status, @Param("title_id") Long titleId);

    Optional<Copy> findByStatusAndTitleId(@Param("copy_status") String status, @Param("title_id") Long titleId);
}
