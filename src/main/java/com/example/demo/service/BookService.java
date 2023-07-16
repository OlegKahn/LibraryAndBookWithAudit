package com.example.demo.service;

import com.example.demo.entity.Book;

import java.util.List;

public interface BookService {

    Book add(Book book);
    Book update(Book book);
    List<Book> getAllBooks();
    Book getBook(long id);
    void delete(long id);
}
