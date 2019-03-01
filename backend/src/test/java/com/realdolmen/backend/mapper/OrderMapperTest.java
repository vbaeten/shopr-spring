package com.realdolmen.backend.mapper;

import com.realdolmen.backend.data.OrderTestDataBuilder;
import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.dto.OrderDto;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class OrderMapperTest {

    private OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    @Test
    public void orderToOrderDTO() throws Exception {
        Order order = OrderTestDataBuilder.buildOrder1().build();
        OrderDto orderDto = orderMapper.orderToOrderDto(order);

        assertEquals(order.getOrderDate(), orderDto.getOrderDate());
        assertEquals(order.getId(), orderDto.getId());
        assertEquals(order.getUser().getFirstName(), orderDto.getUser().getFirstName());
    }

    @Test
    public void orderDtoToOrder() throws Exception {
        OrderDto orderDto = OrderTestDataBuilder.buildOrderDto1().build();
        Order order = orderMapper.orderDtoToOrder(orderDto);

        assertEquals(orderDto.getOrderDate(), order.getOrderDate());
        assertEquals(orderDto.getUser().getName(), order.getUser().getName());
    }

    @Test
    public void testOrderShouldAssertNull() {
        Order order = orderMapper.orderDtoToOrder(null);
        assertNull(order);
    }
    @Test
    public void testOrderDtoShouldAssertNull() {
        OrderDto orderDto = orderMapper.orderToOrderDto(null);
        assertNull(orderDto);
    }
}
