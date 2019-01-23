package com.realdolmen.backend.Domain;

import com.realdolmen.backend.Domain.enums.Bookfictiongenre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;

@Setter
@Getter
@Entity
@DiscriminatorValue("bookfiction")
public class Bookfiction extends Book {

    @Enumerated(EnumType.STRING)
    private Bookfictiongenre bookfictiongenre;
    @Size(max = 255)
    private String summary;
}
