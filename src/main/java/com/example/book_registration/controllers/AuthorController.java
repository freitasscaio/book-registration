package com.example.book_registration.controllers;

import com.example.book_registration.dtos.AuthorDTO;
import com.example.book_registration.dtos.BookResponseDTO;
import com.example.book_registration.models.AuthorModel;
import com.example.book_registration.services.AuthorService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid AuthorDTO authorDTO){
        var author = new AuthorModel();
        BeanUtils.copyProperties(authorDTO, author);
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.save(author));
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<Object> findAllBooksById(@PathVariable Long id){
        Optional<AuthorModel> authorModelOptional = authorService.findById(id);
        if(authorModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autor não encontrado");
        }

        List<BookResponseDTO> book = authorModelOptional.get().getBooks().stream()
                .map(b -> new BookResponseDTO(b.getId(), b.getName(), b.getDescription()))
                .toList();

        return ResponseEntity.ok(book);
    }

}
