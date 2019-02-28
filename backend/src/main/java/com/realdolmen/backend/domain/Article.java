package com.realdolmen.backend.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "article")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@Getter
@Setter
@Builder(builderClassName = "Builder")
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    @NotNull
    @Size(max = 100)
    private String title;

    @Column
    @NotNull
    @Digits(integer = 6, fraction = 2)
    private double price;

    @Column
    @NotNull
    @Size(max = 100)
    private String supplier;

    @Column(name = "type", insertable = false, updatable = false)
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Double.compare(article.price, price) == 0 &&
                Objects.equals(id, article.id) &&
                title.equals(article.title) &&
                Objects.equals(supplier, article.supplier) &&
                Objects.equals(type, article.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, supplier, type);
    }
}
