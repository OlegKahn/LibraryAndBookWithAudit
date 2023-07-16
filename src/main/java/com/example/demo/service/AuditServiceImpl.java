package com.example.demo.service;

import com.example.demo.entity.Audit;
import com.example.demo.entity.Book;
import com.example.demo.entity.Library;
import com.example.demo.repository.AuditRepo;
import com.example.demo.repository.BookRepo;
import com.example.demo.repository.LibraryRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
@AllArgsConstructor
public class AuditServiceImpl implements AuditService{

    private LibraryRepo libraryRepo;

    private BookRepo bookRepo;

    private AuditRepo auditRepo;
    @Override
    public Audit create(Class<?> someClass, long id) {
        Audit audit = new Audit();

        if(someClass == Library.class) {
            Revisions<Long, Library> revisions = libraryRepo.findRevisions(id);
            audit = returnAudit(revisions);

            audit.setEntityType(someClass.getName());

            audit.setCreatedBy("user");
            audit.setModifiedBy("user");

        } else if(someClass == Book.class) {
            Revisions<Long, Book> revisions = bookRepo.findRevisions(id);
            audit = returnAudit(revisions);

            audit.setEntityType(someClass.getName());

            audit.setCreatedBy("user");
            audit.setModifiedBy("user");
        }
        return auditRepo.save(audit);
    }

    private ZonedDateTime getSomeTime(Instant instant) {
        return ZonedDateTime.ofInstant(instant,
                ZoneId.systemDefault());
    }

    private Audit returnAudit(Revisions<Long, ?> revisions) {
        Audit audit = new Audit();

        // there is a mistake, always get first Revision, but have to second to last
        Revision<Long, ?> firstRevision = revisions.getContent().get(0);

        Revision<Long, ?> latestRevision = revisions.getLatestRevision();

        audit.setOperationType(latestRevision.getMetadata().getRevisionType().name());
        audit.setCreatedAt(getSomeTime(firstRevision.getRevisionInstant().orElseThrow()));
        audit.setModifiedAt(getSomeTime(latestRevision.getRevisionInstant().orElseThrow()));

        audit.setEntityJson(getJson(firstRevision.getEntity()));
        audit.setNewEntityJson(getJson(latestRevision.getEntity()));
            return audit;
    }

    private static String getJson(Object revisionEntity) {
        if (revisionEntity.getClass() == Book.class) {
            Book book = (Book)revisionEntity;
            return book.getJson();
        } else if (revisionEntity.getClass() == Library.class) {
            Library library = (Library) revisionEntity;
            return library.getJson();
        } else {
            return null;
        }
    }
}
