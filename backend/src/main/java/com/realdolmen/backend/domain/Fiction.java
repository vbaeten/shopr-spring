package com.realdolmen.backend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@DiscriminatorValue("Fiction")
@Entity
@Table(name = "fiction")
@Getter
@Setter
@NoArgsConstructor
public class Fiction extends Book implements Serializable {

    @Column(name = "genre")
    @Enumerated
    private BookGenre bookGenre;

    @Column
    @Size(max = 255)
    private String synopsis;

    @lombok.Builder(builderClassName = "FictionBuilder")
    public Fiction(Long id, @NotNull @Size(max = 100) String title, @NotNull @Digits(integer = 6, fraction = 2) double price, @NotNull @Size(max = 100) String supplier, String type, @Size(max = 100) String author, @NotNull @Pattern(regexp = "\\d{3}-\\d{2}-\\d{4}-\\d{3}-\\d") String isbn, int pages, BookGenre bookGenre, @Size(max = 255) String synopsis) {
        super(id, title, price, supplier, type, author, isbn, pages);
        this.bookGenre = bookGenre;
        this.synopsis = synopsis;
    }

    public static class FictionBuilder extends BookBuilder {
        FictionBuilder() {super();}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Fiction fiction = (Fiction) o;
        return bookGenre == fiction.bookGenre &&
                Objects.equals(synopsis, fiction.synopsis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bookGenre, synopsis);
    }
}

