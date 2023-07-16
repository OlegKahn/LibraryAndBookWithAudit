package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
@Audited
public class Library {

    @Id
    @SequenceGenerator(name = "library_generator", sequenceName = "library_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "library_generator")
    private long id;

    @Column
    private String name;

    @Column
    private int age;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id")
    private Set<Book> books
            = new HashSet<>();

    public String getJson() {
        return "here some json r = " + new Random().nextInt();
    }
}
