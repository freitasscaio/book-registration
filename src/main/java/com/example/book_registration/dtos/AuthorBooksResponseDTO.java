package com.example.book_registration.dtos;

import java.util.ArrayList;
import java.util.List;

public class AuthorBooksResponseDTO {

    private Long id;

    private String name;

    private List<BookResponseDTO> books = new ArrayList<>();

    public AuthorBooksResponseDTO(Long id, String name, List<BookResponseDTO> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookResponseDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookResponseDTO> books) {
        this.books = books;
    }
}
