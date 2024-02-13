package com.bookstore.bookinventoryservice.service;

import com.bookstore.bookinventoryservice.model.Book;
import com.bookstore.bookinventoryservice.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book createBook(Book book) {
        return repository.save(book);
    }

    public Book getBook(Long id) {
        return repository.findById(id).orElse(null);
    }
}
