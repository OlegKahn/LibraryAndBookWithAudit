//package com.example.demo.controller;
//
//import com.example.demo.entity.Book;
//import com.example.demo.service.BookService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@AllArgsConstructor
//public class DemoTwoController {
//
//    private BookService bookService;
//
//    @PostMapping("/book")
//    public Book addBook(@RequestBody Book book) {
//        return bookService.add(book);
//    }
//
//    @GetMapping("/book")
//    public List<Book> getAllBook() {
//        return bookService.getAllBooks();
//    }
//
//    @GetMapping("/book/{id}")
//    public Book getBook(@PathVariable long id) {
//        return bookService.getBook(id);
//    }
//
//    @PutMapping("/book")
//    public Book update(@RequestBody Book book) {
//        return bookService.update(book);
//    }
//
//    @DeleteMapping("/book/{id}")
//    public void delete(@PathVariable long id) {
//        bookService.delete(id);
//    }
//}
