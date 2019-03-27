package com.realdolmen.backend.dto;

import com.realdolmen.backend.domain.Orderline;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.domain.enums.OrderStatus;

import java.util.List;

public class OrderDto extends BaseObjectDto {
    private Long orderId;
    private List<Orderline> orderlineList;
    private User user;
    private OrderStatus orderStatus;

    @lombok.Builder(builderClassName = "OrderBuilder")
    public OrderDto(Long versionId, List<Orderline> orderlineList, User user, OrderStatus orderStatus) {
        super(versionId);
        this.orderId = orderId;
        this.orderlineList = orderlineList;
        this.user = user;
        this.orderStatus = orderStatus;
    }

    public static class OrderDtoBuilder extends BaseObjectBuilder {
        OrderDtoBuilder() {
            super();
        }
    }
}
