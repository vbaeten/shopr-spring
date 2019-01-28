package com.realdolmen.shoprbackend.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue("fiction book")
@Table(name="fiction")
public class Fiction extends Book{


//    @Enumerated(EnumType.STRING)
//    private BookGenre bookGenre;

    @Size(max=255)
    private String preview;



//    public BookGenre getBookGenre() {
//        return bookGenre;
//    }
//
//    public void setBookGenre(BookGenre bookGenre) {
//        this.bookGenre = bookGenre;
//    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }
}
