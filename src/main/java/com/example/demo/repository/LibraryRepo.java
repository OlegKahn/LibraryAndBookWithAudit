package com.example.demo.repository;

import com.example.demo.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Long>, RevisionRepository<Library, Long, Long> {
}
