package com.realdolmen.backend.domain;


import lombok.Data;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorColumn(name = "book_type")
@DiscriminatorValue("book")
public abstract class Book extends Product {

    private String author;
    private Integer pages;
    private String isbn;
}
