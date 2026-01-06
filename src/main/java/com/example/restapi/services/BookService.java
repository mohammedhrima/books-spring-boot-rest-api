package com.example.restapi.services;

import com.example.restapi.models.Book;
import com.example.restapi.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        if(!bookRepository.findById(id).isPresent()) {
            throw new RuntimeException("Book with id " + id + " not found");
        }
        bookRepository.deleteById(id);
    }
}
