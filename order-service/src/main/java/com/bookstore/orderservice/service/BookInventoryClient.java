package com.bookstore.orderservice.service;

import com.bookstore.orderservice.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-inventory-service")
public interface BookInventoryClient {

    @GetMapping("/books/{id}")
    Book getBookById(@PathVariable("id") Long id);
}
