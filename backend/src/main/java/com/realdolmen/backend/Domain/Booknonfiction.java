package com.realdolmen.backend.Domain;

import com.realdolmen.backend.Domain.enums.Booknonfictiongenre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Setter
@Getter
@Entity
@DiscriminatorValue("booknonfiction")
public class Booknonfiction extends Book {

    @Enumerated(EnumType.STRING)
    private Booknonfictiongenre booknonfictiongenre;
}
