package com.realdolmen.backend.domain;

import com.realdolmen.backend.domain.enums.BookfictionGenre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Setter
@Entity
@DiscriminatorValue("bookfiction")
public class Bookfiction extends Book {
    @Column(name = "bookfiction_genre")
    @Enumerated(EnumType.STRING)
    private BookfictionGenre bookfictionGenre;
    @Size(max = 255)
    private String summary;

    @lombok.Builder(builderClassName = "BookfictionBuilder")
    public Bookfiction(Long versionId, Long articleId, String title, Double price, String supplierId, String type, String author, String isbn, Integer numberOfPages, BookfictionGenre bookfictionGenre, String summary) {
        super(versionId, articleId, title, price, supplierId, type, author, isbn, numberOfPages);
        this.bookfictionGenre = bookfictionGenre;
        this.summary = summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bookfiction)) return false;
        if (!super.equals(o)) return false;
        Bookfiction that = (Bookfiction) o;
        return bookfictionGenre == that.bookfictionGenre &&
                Objects.equals(summary, that.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bookfictionGenre, summary);
    }

    public static class BookfictionBuilder extends BookBuilder {
        BookfictionBuilder() {
            super();
        }
    }
}
