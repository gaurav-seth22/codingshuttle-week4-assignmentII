package com.codingshuttle.librarymanagementsystem.repositories;



import com.codingshuttle.librarymanagementsystem.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {

    List<BookEntity> findByAuthorId(Long authorId);
    List<BookEntity> findByPublishDateAfter(LocalDate date);
    List<BookEntity> findByTitleContainingIgnoreCase(String title);

}
