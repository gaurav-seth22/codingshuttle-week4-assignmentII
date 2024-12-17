package com.codingshuttle.librarymanagementsystem.services;


import com.codingshuttle.librarymanagementsystem.dto.BookDTO;
import com.codingshuttle.librarymanagementsystem.entities.AuthorEntity;
import com.codingshuttle.librarymanagementsystem.entities.BookEntity;
import com.codingshuttle.librarymanagementsystem.repositories.AuthorRepository;
import com.codingshuttle.librarymanagementsystem.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;



//create book

    public BookDTO createBook(BookDTO bookDto){
        //Convert dto to entity
        BookEntity bookEntity=modelMapper.map(bookDto,BookEntity.class);

        //Check author exist in table with id
        AuthorEntity authorEntity=authorRepository.
                findById(bookDto.getAuthorId())
                .orElseThrow(()-> new RuntimeException("Author id is not found"));

        bookEntity.setAuthor(authorEntity);
        BookEntity saveEntity=bookRepository.save(bookEntity);

        return modelMapper.map(saveEntity, BookDTO.class);


    }


//getAll books

    public List<BookDTO> getAllBooks(){

        return bookRepository.findAll()
                .stream()
                .map(bookEntity -> modelMapper.map(bookEntity, BookDTO.class))
                .collect(Collectors.toList());
    }

//getbookbyId

    public BookDTO getBookById(Long id){

       BookEntity bookEntity=bookRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("Book id is not found"));

       return modelMapper.map(bookEntity, BookDTO.class);


    }

//update book

    public BookDTO updateBookById(BookDTO bookDTO,Long id){
        //Convert dto to entity
        BookEntity updatedBookEntity=modelMapper.map(bookDTO,BookEntity.class);
        updatedBookEntity.setId(id);

       return modelMapper.map(bookRepository.save(updatedBookEntity),BookDTO.class);


    }

//delete book

    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }

//book by title

    public List<BookDTO> findBooksByTitle(String title){
       return bookRepository.findByTitleContainingIgnoreCase(title)
               .stream()
               .map(bookEntity -> modelMapper.map(bookEntity, BookDTO.class))
               .collect(Collectors.toList());
    }

//books after publish date

    public List<BookDTO> findBooksByPublishDateAfter(LocalDate date){
        return  bookRepository.findByPublishDateAfter(date)
                .stream()
                .map(bookEntity -> modelMapper.map(bookEntity, BookDTO.class))
                .collect(Collectors.toList());
    }

//books by author

    public List<BookDTO> findBooksByAuthor(Long authorId){
        return bookRepository.findByAuthorId(authorId)
                .stream()
                .map(bookEntity -> modelMapper.map(bookEntity, BookDTO.class))
                .collect(Collectors.toList());
    }
}
