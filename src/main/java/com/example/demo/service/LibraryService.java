package com.example.demo.service;


import com.example.demo.entity.Library;
import java.util.List;

public interface LibraryService {

    Library add(Library library);
    Library update(Library library);
    List<Library> getAllLibraries();
    Library getLibrary(long id);
    void delete(long id);
}
