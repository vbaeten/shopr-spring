package com.realdolmen.backend.domain;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "type")
@NoArgsConstructor
@EqualsAndHashCode
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Game.class, name = "game"),
        @JsonSubTypes.Type(value = Lp.class, name = "lp"),
        @JsonSubTypes.Type(value = Fiction.class, name = "fiction"),
        @JsonSubTypes.Type(value = NonFiction.class, name = "nonFiction"),
})
public abstract class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long articleId;

    @NotNull
    @Size(max = 100)
    @Column(name = "title")
    private String title;
    @Digits(integer = 4, fraction = 2)
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
