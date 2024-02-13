package com.bookstore.bookinventoryservice.repository;

import com.bookstore.bookinventoryservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
