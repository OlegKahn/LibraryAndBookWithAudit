package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService{

    private BookRepo bookRepo;
    private AuditService auditService;
    @Override
    public Book add(Book book) {
        Book savedBook = bookRepo.save(book);
        auditService.create(Book.class, savedBook.getId());
        return savedBook;
    }

    @Override
    public Book update(Book book) {
        Book updatedBook = bookRepo.save(book);
        auditService.create(Book.class, updatedBook.getId());
        return updatedBook;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book getBook(long id) {
        return bookRepo.findById(id).orElseThrow();
    }

    @Override
    public void delete(long id) {
        bookRepo.deleteById(id);
        auditService.create(Book.class, id);
    }
}
