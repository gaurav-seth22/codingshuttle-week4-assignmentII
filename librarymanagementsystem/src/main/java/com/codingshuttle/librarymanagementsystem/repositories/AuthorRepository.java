package com.codingshuttle.librarymanagementsystem.repositories;




import com.codingshuttle.librarymanagementsystem.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {

    List<AuthorEntity> findByNameContainingIgnoreCase(String authorName);
}
