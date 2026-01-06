package com.example.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
