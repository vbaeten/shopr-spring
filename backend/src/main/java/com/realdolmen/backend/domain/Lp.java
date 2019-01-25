package com.realdolmen.backend.domain;

import com.realdolmen.backend.domain.enums.LpGenre;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "lp")
@DiscriminatorValue("lp")
public class Lp extends Product {

    private String performer;

    @Enumerated
    private LpGenre genre;
}
