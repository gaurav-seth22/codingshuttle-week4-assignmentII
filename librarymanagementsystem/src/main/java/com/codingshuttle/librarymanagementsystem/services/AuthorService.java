package com.codingshuttle.librarymanagementsystem.services;


import com.codingshuttle.librarymanagementsystem.dto.AuthorDTO;
import com.codingshuttle.librarymanagementsystem.entities.AuthorEntity;
import com.codingshuttle.librarymanagementsystem.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final ModelMapper modelMapper;

    private final AuthorRepository authorRepository;



    //create Author
    public AuthorDTO createAuthor(AuthorDTO authorDTO){

       // AuthorEntity authorEntity=modelMapper.map(authorDTO, AuthorEntity.class);

       // return modelMapper.map(authorRepository.save(authorEntity), AuthorDTO.class);


       return modelMapper.map(authorRepository
                .save(modelMapper.map(authorDTO, AuthorEntity.class))
                , AuthorDTO.class);
    }


    //get all Authors

    public List<AuthorDTO> getAllAuthor(){
       return authorRepository.findAll()
                .stream()
                .map(authorEntity -> modelMapper.map(authorEntity, AuthorDTO.class))
                .collect(Collectors.toList());


    }

    //get Author by id

    public AuthorDTO getAuthorById(Long id){

       AuthorEntity authorEntity= authorRepository
               .findById(id)
               .orElseThrow(
                       ()-> new RuntimeException("Author is not found")
               );

       return modelMapper.map(authorEntity, AuthorDTO.class);
    }

    //Update Author
        public AuthorDTO updateAuthorById(AuthorDTO authorDTO,Long id){
        AuthorEntity updatedAuthorEntity=modelMapper.map(authorDTO, AuthorEntity.class);
            System.out.println(updatedAuthorEntity);
            updatedAuthorEntity.setId(id);
        return modelMapper.map(authorRepository.save(updatedAuthorEntity), AuthorDTO.class);
    }

    //Delete Author
    public void deleteAuthor(Long id){
        authorRepository.deleteById(id);
    }

    //get author by name
    public List<AuthorDTO> getAuthorByName(String authorName){

        return authorRepository.findByNameContainingIgnoreCase(authorName)
                .stream()
                .map(authorEntity -> modelMapper.map(authorEntity, AuthorDTO.class))
                .collect(Collectors.toList());



    }
}
