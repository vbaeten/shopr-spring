package com.realdolmen.backend.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "type")
@NoArgsConstructor
@EqualsAndHashCode
public abstract class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @NotNull
    @Size(max = 100)
    @Column(name = "title")
    private String title;
    @NotNull
    @Digits(integer = 6, fraction = 2)
    @Column(name = "price")
    private BigDecimal price;
    @NotNull
    @Size(max = 100)
    @Column(name = "ID_supplier")
    private String supplierId;
    @Column(name = "type", insertable = false, updatable = false)
    private String type;

    public Article(@NotNull @Size(max = 100) String title, @NotNull @Digits(integer = 6, fraction = 2) BigDecimal price, @NotNull @Size(max = 100) String supplierId, String type) {
        this.title = title;
        this.price = price;
        this.supplierId = supplierId;
        this.type = type;
    }
}
