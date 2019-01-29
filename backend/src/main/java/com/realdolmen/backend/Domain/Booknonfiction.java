package com.realdolmen.backend.Domain;

import com.realdolmen.backend.Domain.enums.BooknonfictionGenre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@DiscriminatorValue("booknonfiction")
public class Booknonfiction extends Book {
    @Column(name = "booknonfiction_genre")
    @Enumerated(EnumType.STRING)
    private BooknonfictionGenre booknonfictionGenre;
}
