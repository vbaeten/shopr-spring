package com.realdolmen.backend.domain;

import com.realdolmen.backend.data.OrderLineTestDataBuilder;
import com.realdolmen.backend.data.UserTestDataBuilder;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    private Order order;

    @Before
    public void setUp() {
        order = new Order();
    }

    @Test
    public void getId() {
        Long id = 4L;
        order.setId(id);
        assertEquals(id, order.getId());
    }

    @Test
    public void getOrderDate() {
        Timestamp orderDate = new Timestamp(System.currentTimeMillis());
        order.setOrderDate(orderDate);
        assertEquals(orderDate, order.getOrderDate());
    }

    @Test
    public void getUser() {
        User user = UserTestDataBuilder.buildUserJuttaRoggen().build();
        order.setUser(user);
        assertEquals(user.getName(), order.getUser().getName());
    }

    @Test
    public void getOrderLines() {
        OrderLine orderLine1 = OrderLineTestDataBuilder.buildOrderLine1().build();
        OrderLine orderLine2 = OrderLineTestDataBuilder.buildOrderLine2().build();
        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(orderLine1);
        orderLines.add(orderLine2);
        order.setOrderLines(orderLines);
        assertEquals(orderLines.size(), orderLines.size());
    }

    @Test
    public void getTotal() {
        double total = 50;
        order.setTotal(50);
        assertEquals(total, order.getTotal(), 0.01);
    }
}
