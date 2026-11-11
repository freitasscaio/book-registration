package com.example.book_registration.services;

import com.example.book_registration.models.BookModel;
import com.example.book_registration.repositories.AuthorRepository;
import com.example.book_registration.repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Transactional
    public BookModel save(BookModel bookModel) {
        return bookRepository.save(bookModel);
    }

    public List<BookModel> findAll() {
        return bookRepository.findAll();
    }

    public Optional<BookModel> findById(UUID id){
        return bookRepository.findById(id);
    }

    @Transactional
    public void delete(BookModel bookModel) {
        bookRepository.delete(bookModel);
    }

}
