package com.realdolmen.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Book extends Article implements Serializable {

    @Column
    @Size(max = 100)
    private String author;

    @Column
    @NotNull
    @Pattern(regexp="\\d{3}-\\d{2}-\\d{4}-\\d{3}-\\d")
    private long isbn;

    @Column
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
