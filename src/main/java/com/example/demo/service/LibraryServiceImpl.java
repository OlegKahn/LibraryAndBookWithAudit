package com.example.demo.service;

import com.example.demo.entity.Library;
import com.example.demo.repository.LibraryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LibraryServiceImpl implements LibraryService{

    private LibraryRepo libraryRepo;

    private AuditService auditService;

    @Override
    public Library add(Library library) {

        Library savedLibrary = libraryRepo.save(library);
        auditService.create(Library.class, savedLibrary.getId());
        return savedLibrary;
    }

    @Override
    public Library update(Library library) {
        Library updatedLibrary = libraryRepo.save(library);
        auditService.create(Library.class, updatedLibrary.getId());
        return updatedLibrary;
    }

    @Override
    public List<Library> getAllLibraries() {
        return libraryRepo.findAll();
    }

    @Override
    public Library getLibrary(long id) {
        return libraryRepo.findById(id).orElseThrow();
    }

    @Override
    public void delete(long id) {
        libraryRepo.deleteById(id);
        auditService.create(Library.class, id);
    }
}
