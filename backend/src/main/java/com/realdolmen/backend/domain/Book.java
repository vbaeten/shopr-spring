package com.realdolmen.backend.domain;


import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public abstract class Book extends Product {

    private String author;
    private Integer pages;
    private String isbn;
}
