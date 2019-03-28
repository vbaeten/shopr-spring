package com.realdolmen.backend.domain;

import com.realdolmen.backend.domain.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Table(name = "Orders")
@Entity
@Getter
@Setter
public class Order extends BaseObject {

    @Id
    @GeneratedValue
    private Long orderId;

    @OneToMany
    @JoinColumn(name = "orderId")
    private List<Orderline> orderlineList;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId")
    private User user;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @lombok.Builder(builderClassName = "OrderBuilder")
    public Order(Long versionId, List<Orderline> orderlineList, User user, OrderStatus orderStatus) {
        super(versionId);
        this.orderId = orderId;
        this.orderlineList = orderlineList;
        this.user = user;
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) &&
                Objects.equals(orderlineList, order.orderlineList) &&
                Objects.equals(user, order.user) &&
                orderStatus == order.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orderId, orderlineList, user, orderStatus);
    }

    public static class OrderBuilder extends BaseObjectBuilder {
        OrderBuilder() {
            super();
        }
    }
}
