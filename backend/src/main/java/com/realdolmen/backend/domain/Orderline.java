package com.realdolmen.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Orderline extends BaseObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderlineId;

    @Digits(integer = 6, fraction = 2)
    private Double subTotal;

    @Digits(integer = 6, fraction = 0)
    @NotNull
    private Long quantity;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "articleId")
    private Article article;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    private Order order;

    @lombok.Builder(builderClassName = "OrderlineBuilder")
    public Orderline(Long versionId, Long orderlineId, Double subTotal, Long quantity, Article article, Order order) {
        super(versionId);
        this.orderlineId = orderlineId;
        this.subTotal = subTotal;
        this.quantity = quantity;
        this.article = article;
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orderline)) return false;
        if (!super.equals(o)) return false;
        Orderline orderline = (Orderline) o;
        return Objects.equals(orderlineId, orderline.orderlineId) &&
                Objects.equals(subTotal, orderline.subTotal) &&
                Objects.equals(quantity, orderline.quantity) &&
                Objects.equals(article, orderline.article) &&
                Objects.equals(order, orderline.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orderlineId, subTotal, quantity, article, order);
    }

    public static class OrderlineBuilder extends BaseObjectBuilder {
        OrderlineBuilder() {
            super();
        }
    }
}
