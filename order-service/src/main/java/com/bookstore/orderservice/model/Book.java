package com.bookstore.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {

    private Long id;

    private String title;
    private String author;
    private String isbn;
    private double price;
    private int stock;

}
