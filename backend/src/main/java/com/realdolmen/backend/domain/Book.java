package com.realdolmen.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;


@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Book extends Article {
    @Size(max = 100)
    private String author;
    @Column(unique = true)
//    @Pattern(regexp = "\\d{3}\\-\\d{2}\\-\\d{4}\\-\\d{3}\\-\\d")
    @Size(max = 20)
    @NotBlank
    private String isbn;
    private Integer numberOfPages;

    @lombok.Builder(builderClassName = "BookBuilder")
    public Book(Long versionId, Long articleId, String title, Double price, String supplierId, String type, String author, String isbn, Integer numberOfPages) {
        super(versionId, articleId, title, price, supplierId, type);
        this.author = author;
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getIsbn(), book.getIsbn()) &&
                Objects.equals(getNumberOfPages(), book.getNumberOfPages());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getIsbn(), getNumberOfPages());
    }

    public static class BookBuilder extends ArticleBuilder {
        BookBuilder() {
            super();
        }
    }
}
