package com.realdolmen.backend.domain;

import com.realdolmen.backend.domain.enums.BooknonfictionGenre;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("booknonfiction")
public class Booknonfiction extends Book {
    @Column(name = "booknonfiction_genre")
    @Enumerated(EnumType.STRING)
    private BooknonfictionGenre booknonfictionGenre;

    @lombok.Builder(builderClassName = "BooknonfictionBuilder")
    public Booknonfiction(Long versionId, Long articleId, String title, Double price, String supplierId, String type, String author, String isbn, Integer numberOfPages, BooknonfictionGenre booknonfictionGenre) {
        super(versionId, articleId, title, price, supplierId, type, author, isbn, numberOfPages);
        this.booknonfictionGenre = booknonfictionGenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booknonfiction)) return false;
        if (!super.equals(o)) return false;
        Booknonfiction that = (Booknonfiction) o;
        return booknonfictionGenre == that.booknonfictionGenre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), booknonfictionGenre);
    }

    public static class BooknonfictionBuilder extends BookBuilder {
        BooknonfictionBuilder() {
            super();
        }
    }
}
