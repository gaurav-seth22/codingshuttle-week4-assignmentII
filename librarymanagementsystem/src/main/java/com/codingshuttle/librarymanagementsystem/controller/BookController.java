package com.codingshuttle.librarymanagementsystem.controller;


import com.codingshuttle.librarymanagementsystem.dto.BookDTO;
import com.codingshuttle.librarymanagementsystem.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;



    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO){
        return ResponseEntity.ok(bookService.createBook(bookDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBooksById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.getBookById(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBookById(@RequestBody BookDTO bookDTO,@PathVariable Long id){

        return ResponseEntity.ok(bookService.updateBookById(bookDTO,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
        return  ResponseEntity.noContent().build();

    }

    @GetMapping("/title")
    public ResponseEntity<List<BookDTO>> findBooksByTitle(@RequestParam String title){
        return  ResponseEntity.ok(bookService.findBooksByTitle(title));
    }

    @GetMapping("/date")
    public ResponseEntity<List<BookDTO>> findBooksByPublishDateAfter(@RequestParam String date){
        return ResponseEntity.ok(bookService.findBooksByPublishDateAfter(LocalDate.parse(date)));

    }


}
