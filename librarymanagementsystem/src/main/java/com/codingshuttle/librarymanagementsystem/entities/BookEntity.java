package com.codingshuttle.librarymanagementsystem.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "book_entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDate publishDate;


    @ManyToOne(fetch = FetchType.LAZY) //Owning side
    @JoinColumn(name="author_id",nullable = false)
    private AuthorEntity author;



}
