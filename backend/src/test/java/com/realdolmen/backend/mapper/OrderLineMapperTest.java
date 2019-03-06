package com.realdolmen.backend.mapper;

import com.realdolmen.backend.data.OrderLineTestDataBuilder;
import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.dto.OrderLineDto;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class OrderLineMapperTest {

    private OrderLineMapper orderLineMapper = Mappers.getMapper(OrderLineMapper.class);

    @Test
    public void orderLineToOrderLineDTO() throws Exception {
        OrderLine orderLine = OrderLineTestDataBuilder.buildOrderLine1().build();
        OrderLineDto orderLineDto = orderLineMapper.orderLineToOrderLineDto(orderLine);

        assertEquals(orderLine.getQuantity(), orderLineDto.getQuantity());
        assertEquals(orderLine.getId(), orderLineDto.getId());
    }

    @Test
    public void orderLineDtoToOrderLine() throws Exception {
        OrderLineDto orderLineDto = OrderLineTestDataBuilder.buildOrderLine2Dto().build();
        OrderLine orderLine = orderLineMapper.orderLineDtoToOrderLine(orderLineDto);

        assertEquals(orderLineDto.getId(), orderLine.getId());
        assertEquals(orderLineDto.getUser().getName(), orderLine.getUser().getName());
    }

    @Test
    public void testOrderLineShouldAssertNull() {
        OrderLine orderLine = orderLineMapper.orderLineDtoToOrderLine(null);
        assertNull(orderLine);
    }
    @Test
    public void testOrderLineDtoShouldAssertNull() {
        OrderLineDto orderLineDto = orderLineMapper.orderLineToOrderLineDto(null);
        assertNull(orderLineDto);
    }
}
