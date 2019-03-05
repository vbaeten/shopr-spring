package com.realdolmen.backend.facade;

import com.realdolmen.backend.data.OrderLineTestDataBuilder;
import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.dto.OrderLineDto;
import com.realdolmen.backend.mapper.OrderLineMapper;
import com.realdolmen.backend.service.OrderLineService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class OrderLineFacadeTest {

    @InjectMocks
    private OrderLineFacade orderLineFacade;

    @Mock
    private OrderLineService orderLineService;
    @Mock
    private OrderLineMapper orderLineMapper;

    private OrderLine orderLine;

    @Before
    public void setUp() throws Exception {
        orderLine = OrderLineTestDataBuilder.buildOrderLine1().build();
    }

    @Test
    public void createOrderLine() {
    }

    @Test
    public void deleteOrderLine() {
    }

    @Test
    public void loadShoppingCart() {
    }

    @Test
    public void findByOrderLineId() {
    }

    @Test
    public void delete() {
        OrderLineDto orderLineDto = OrderLineTestDataBuilder.buildOrderLine2Dto().build();
        orderLineFacade.deleteOrderLine(orderLineDto);

        verify(orderLineService, times(1)).delete(any());
    }

    @Test
    public void deleteById() {
        orderLineFacade.deleteById(any());

        verify(orderLineService, times(1)).deleteById(any());
    }
}
