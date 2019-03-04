package com.realdolmen.backend.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "non_fiction")
@DiscriminatorValue("Non-Fiction")
@AllArgsConstructor
@NoArgsConstructor
public class NonFiction extends Book implements Serializable {

    @Column
    private Subject subject;

//    @lombok.Builder(builderClassName = "NonFictionBuilder")
//    public NonFiction(String author, long isbn, int pages, Subject subject) {
//        super(author, isbn, pages);
//        this.subject = subject;
//    }
//
//    public static class NonFictionBuilder extends Book.Builder {
//        NonFictionBuilder() {super();}
//    }

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
