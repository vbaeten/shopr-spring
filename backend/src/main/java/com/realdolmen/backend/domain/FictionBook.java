package com.realdolmen.backend.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@DiscriminatorValue("Fiction")
@Entity
@Table(name = "fiction")
public class FictionBook extends Book implements Serializable {

    @Column(name = "genre")
    @Enumerated
    private BookGenre bookGenre;

    @Column
    @Size(max = 255)
    private String synopsis;

    public BookGenre getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(BookGenre bookGenre) {
        this.bookGenre = bookGenre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
