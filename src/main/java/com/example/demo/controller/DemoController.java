package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.Library;
import com.example.demo.service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
public class DemoController {

    private LibraryService libraryService;

    @PostMapping("/lib")
    public Library addLibrary(@RequestBody Library library) {
        return libraryService.add(library);
    }

    @PostMapping("/lib/{id}")
    public Set<Book> addBookToLibrary(@PathVariable long id, @RequestBody Book book) {
        Library library = libraryService.getLibrary(id);
        library.getBooks().add(book);
        return libraryService.update(library).getBooks();
    }

    @GetMapping("/lib")
    public List<Library> getAllLibrary() {
        return libraryService.getAllLibraries();
    }

    @GetMapping("/lib/{id}")
    public Library getLibrary(@PathVariable long id) {
        return libraryService.getLibrary(id);
    }

    @PutMapping("/lib")
    public Library update(@RequestBody Library library) {
        return libraryService.update(library);
    }

    @DeleteMapping("/lib/{id}")
    public void delete(@PathVariable long id) {
        libraryService.delete(id);
    }
}
