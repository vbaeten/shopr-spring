package com.realdolmen.backend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ArticleDto extends BaseObjectDto {

    private Long articleId;
    private String title;
    private Double price;
    private String supplierId;
    private String type;

    @lombok.Builder(builderClassName = "ArticleBuilder")
    public ArticleDto(Long versionId, Long articleId, String title, Double price, String supplierId, String type) {
        super(versionId);
        this.articleId = articleId;
        this.title = title;
        this.price = price;
        this.supplierId = supplierId;
        this.type = type;
    }

    public static class ArticleDtoBuilder extends BaseObjectBuilder {
        ArticleDtoBuilder() {
            super();
        }
    }
}
