package com.realdolmen.shoprbackend.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue("fiction book")
public class Fiction extends Book{


    @Enumerated(EnumType.STRING)
    private BookGenre bookGenre;

    @Size(max=255)
    private String preview;



    public BookGenre getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(BookGenre bookGenre) {
        this.bookGenre = bookGenre;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }
}
