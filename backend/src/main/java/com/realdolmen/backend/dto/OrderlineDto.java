package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.Article;
import com.realdolmen.backend.domain.Order;

public class OrderlineDto extends BaseObjectDto {
    private Long orderlineId;
    private Double subTotal;
    private Long quantity;
    private Article article;
    private Order order;

    @lombok.Builder(builderClassName = "OrderlineBuilder")
    public OrderlineDto(Long versionId, Long orderlineId, Double subTotal, Long quantity, Article article, Order order) {
        super(versionId);
        this.orderlineId = orderlineId;
        this.subTotal = subTotal;
        this.quantity = quantity;
        this.article = article;
        this.order = order;
    }

    public static class OrderDtoBuilder extends BaseObjectBuilder {
        OrderDtoBuilder() {
            super();
        }
    }
}
