package com.codingshuttle.librarymanagementsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "author_entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL, orphanRemoval = true)//Inverse side
    private List<BookEntity> bookList;
}
