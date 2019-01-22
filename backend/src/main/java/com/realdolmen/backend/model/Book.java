package com.realdolmen.backend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "book_type")
@DiscriminatorValue(value = "book")
public abstract class Book extends Article
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private String author;
    private String isbn;
    private int nrPages;

}
