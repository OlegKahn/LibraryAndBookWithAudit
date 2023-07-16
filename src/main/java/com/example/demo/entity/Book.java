package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
@Audited
public class Book {

    @Id
    @SequenceGenerator(name = "book_generator", sequenceName = "book_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
    public long id;

    @Column
    private String author;

    @Column
    private String name;

    public String getJson() {
        return "тут типа json r = " + new Random().nextInt();
    }
}
