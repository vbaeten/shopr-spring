package com.realdolmen.backend.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table
@DiscriminatorValue("lp")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Lp extends Article {

    @Size(max = 100)
    @Column(name = "publisher")
    private String publisher;

    @Enumerated(EnumType.STRING)
    private LpGenre lpGenre;

    @lombok.Builder(builderClassName = "Builder")
    public Lp(@NotNull @Size(max = 100) String title, @NotNull @Digits(integer = 6, fraction = 2) BigDecimal price, @NotNull @Size(max = 100) String supplierId, String type, @Size(max = 100) String publisher, LpGenre lpGenre) {
        super(title, price, supplierId, type);
        this.publisher = publisher;
        this.lpGenre = lpGenre;
    }

}
