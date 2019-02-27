package com.realdolmen.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@DiscriminatorValue("Fiction")
@Entity
@Table(name = "fiction")
@Getter
@Setter
public class Fiction extends Book implements Serializable {

    @Column(name = "genre")
    @Enumerated
    private BookGenre bookGenre;

    @Column
    @Size(max = 255)
    private String synopsis;

    public Fiction() {
    }

    public Fiction(BookGenre bookGenre, @Size(max = 255) String synopsis) {
        this.bookGenre = bookGenre;
        this.synopsis = synopsis;
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

