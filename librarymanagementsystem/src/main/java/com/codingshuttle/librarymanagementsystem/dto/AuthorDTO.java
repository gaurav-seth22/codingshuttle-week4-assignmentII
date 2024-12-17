package com.codingshuttle.librarymanagementsystem.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {


    private Long id;




    private String name;
    private List<BookDTO> bookList;


}
