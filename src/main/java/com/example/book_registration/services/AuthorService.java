package com.example.book_registration.services;

import com.example.book_registration.models.AuthorModel;
import com.example.book_registration.models.BookModel;
import com.example.book_registration.repositories.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public AuthorModel save(AuthorModel authorModel){
        return authorRepository.save(authorModel);
    }

    public List<AuthorModel> findAll(){
        return authorRepository.findAll();
    }

    public Optional<AuthorModel> findById(Long id){
        return authorRepository.findById(id);
    }

    public void delete(AuthorModel authorModel){
        authorRepository.delete(authorModel);
    }

}
