package com.realdolmen.backend.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "non_fiction")
@DiscriminatorValue("Non-Fiction")
@NoArgsConstructor
public class NonFiction extends Book implements Serializable {

    @Column
    private Subject subject;


    @lombok.Builder(builderClassName = "NonFictionBuilder")
    public NonFiction(Long id, @NotNull @Size(max = 100) String title, @NotNull @Digits(integer = 6, fraction = 2) double price, @NotNull @Size(max = 100) String supplier, String type, @Size(max = 100) String author, @NotNull @Pattern(regexp = "\\d{3}-\\d{2}-\\d{4}-\\d{3}-\\d") long isbn, int pages, Subject subject) {
        super(id, title, price, supplier, type, author, isbn, pages);
        this.subject = subject;
    }

    public static class NonFictionBuilder extends BookBuilder {
        NonFictionBuilder() {super();}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NonFiction that = (NonFiction) o;
        return subject == that.subject;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subject);
    }
}
