package com.realdolmen.backend.domain;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Book extends Article implements Serializable {

    private String author;
    private long isbn;
    private int pages;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
