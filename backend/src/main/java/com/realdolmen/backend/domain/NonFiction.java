package com.realdolmen.backend.domain;

import com.realdolmen.backend.domain.enums.NonFictionGenre;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "nonFiction")
@DiscriminatorValue("nonFiction")
public class NonFiction extends Book {

    @Enumerated
    private NonFictionGenre genre;
}
