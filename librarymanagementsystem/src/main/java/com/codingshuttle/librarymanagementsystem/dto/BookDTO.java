package com.codingshuttle.librarymanagementsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {


    private Long id;


    private String title;



    private LocalDate publishDate;
    //private AuthorEntity author;

    private Long authorId;
}
