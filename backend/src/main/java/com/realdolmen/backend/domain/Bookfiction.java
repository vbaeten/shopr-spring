package com.realdolmen.backend.domain;

import com.realdolmen.backend.domain.enums.BookfictionGenre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Setter
@Getter
@Entity
@DiscriminatorValue("bookfiction")
public class Bookfiction extends Book {
    @Column(name = "bookfiction_genre")
    @Enumerated(EnumType.STRING)
    private BookfictionGenre bookfictionGenre;
    @Size(max = 255)
    private String summary;
}
