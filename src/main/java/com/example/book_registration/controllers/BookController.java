package com.example.book_registration.controllers;

import com.example.book_registration.dtos.BookDTO;
import com.example.book_registration.models.AuthorModel;
import com.example.book_registration.models.BookModel;
import com.example.book_registration.repositories.AuthorRepository;
import com.example.book_registration.services.BookService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorRepository authorRepository;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Object> saveBook(@RequestBody @Valid BookDTO bookDTO){
        Optional<AuthorModel> author = authorRepository.findById(bookDTO.getAuthorId());
        if(author.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Autor não encontrado");
        }

        var book = new BookModel();
        BeanUtils.copyProperties(bookDTO, book);
        book.setAuthorId(author.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(book));
    }

    @GetMapping
    public ResponseEntity<List<BookModel>> findAllBook(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneBook (@PathVariable UUID id){
        Optional<BookModel> bookModelOptional = bookService.findById(id);
        if(!bookModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(bookModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook (@PathVariable UUID id){
        Optional<BookModel> bookModelOptional = bookService.findById(id);
        if(!bookModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }

}
