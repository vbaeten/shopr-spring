package com.realdolmen.backend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book extends Article implements Serializable {

    @Column
    @Size(max = 100)
    private String author;

    @Column
    private @NotNull @Pattern(regexp = "\\d{3}-\\d{2}-\\d{4}-\\d{3}-\\d") String isbn;

    @Column
    private int pages;

    @lombok.Builder(builderClassName = "BookBuilder")
    public Book(Long id, @NotNull @Size(max = 100) String title, @NotNull @Digits(integer = 6, fraction = 2) double price, @NotNull @Size(max = 100) String supplier, String type, @Size(max = 100) String author, @NotNull @Pattern(regexp = "\\d{3}-\\d{2}-\\d{4}-\\d{3}-\\d") String isbn, int pages) {
        super(id, title, price, supplier, type);
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
    }

    public static class BookBuilder extends Builder {
        BookBuilder() {
            super();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return isbn == book.isbn &&
                pages == book.pages &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, isbn, pages);
    }
}
