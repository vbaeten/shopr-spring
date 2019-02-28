package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.domain.User;

import java.util.ArrayList;
import java.util.List;

public class OrderTestDataBuilder {

    public static Order.Builder buildOrder1() {
        User user = UserTestDataBuilder.buildUserBernadetteSanz().build();
        OrderLine orderLine1 = OrderLineTestDataBuilder.buildOrderLine1().build();
        OrderLine orderLine2 = OrderLineTestDataBuilder.buildOrderLine2().build();
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(orderLine1);
        orderLines.add(orderLine2);
        return Order.builder().id(1L).total(500).user(user).orderLines(orderLines);
    }
}
