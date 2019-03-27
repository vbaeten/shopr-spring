package com.realdolmen.backend.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
public class Article extends BaseObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Size(max = 100)
   @NotBlank
    private String title;

    @NotNull
    @Digits(integer = 6, fraction = 2)
    private Double price;

    @Size(max = 100)
    @NotBlank
    private String supplierId;

    @NotNull
    @Column(insertable = false, updatable = false)
    private String type;

    @lombok.Builder(builderClassName = "ArticleBuilder")
    public Article(Long versionId, Long articleId, String title, Double price, String supplierId, String type) {
        super(versionId);
        this.articleId = articleId;
        this.title = title;
        this.price = price;
        this.supplierId = supplierId;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        if (!super.equals(o)) return false;
        Article article = (Article) o;
        return Objects.equals(articleId, article.articleId) &&
                Objects.equals(title, article.title) &&
                Objects.equals(price, article.price) &&
                Objects.equals(supplierId, article.supplierId) &&
                Objects.equals(type, article.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), articleId, title, price, supplierId, type);
    }

    public static class ArticleBuilder extends BaseObjectBuilder {
        ArticleBuilder() {
            super();
        }
    }
}
