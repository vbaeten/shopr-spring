package com.realdolmen.shoprbackend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity

public abstract class Book extends Item{


    @Size(max=100)
    private String author;


    @Column(unique = true)
    private String isbn;

    @Column(name="total_pages")
    private Short totalPages;




    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Short getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Short totalPages) {
        this.totalPages = totalPages;
    }
}
