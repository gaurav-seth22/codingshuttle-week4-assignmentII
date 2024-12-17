package com.codingshuttle.librarymanagementsystem.controller;


import com.codingshuttle.librarymanagementsystem.dto.AuthorDTO;
import com.codingshuttle.librarymanagementsystem.services.AuthorService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

private final AuthorService authorService;



    @GetMapping
public ResponseEntity<List<AuthorDTO>> getAllAuthors(){

    return ResponseEntity.ok(authorService.getAllAuthor());

}

@PostMapping()
public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO){

    return ResponseEntity.ok(authorService.createAuthor(authorDTO));
}

@GetMapping("/{id}")
public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Long id){
    return ResponseEntity.ok(authorService.getAuthorById(id));

}

@PutMapping("/{id}")
public ResponseEntity<AuthorDTO> updateAuthorById(@RequestBody AuthorDTO authorDTO,@PathVariable Long id){
    return ResponseEntity.ok(authorService.updateAuthorById(authorDTO,id));

}

@DeleteMapping("/{id}")
public ResponseEntity<AuthorDTO> deleteAuthor(@PathVariable Long id){
   authorService.deleteAuthor(id);
   return ResponseEntity.noContent().build();

}

@GetMapping("/name")
public ResponseEntity<List<AuthorDTO>> getAuthorByName(@RequestParam String name){
    return ResponseEntity.ok(authorService.getAuthorByName(name));
}

}
