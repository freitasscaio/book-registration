package com.example.book_registration.repositories;

import com.example.book_registration.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorModel, Long> {
}
