package com.realdolmen.backend.service;

import com.realdolmen.backend.data.OrderLineTestDataBuilder;
import com.realdolmen.backend.domain.OrderLine;
import com.realdolmen.backend.repository.OrderLineRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OrderLineServiceImplTest {

    @Mock
    private OrderLineRepository orderLineRepository;

    @InjectMocks
    private OrderLineServiceImpl orderLineServiceImpl;

    @Test
    public void shouldMockService() {
        assertNotNull(orderLineServiceImpl);
    }

    @Test
    public void save() {
        OrderLine expectedOrderLine = OrderLineTestDataBuilder.buildOrderLine1().build();

        when(orderLineRepository.save(any())).thenReturn(expectedOrderLine);

        OrderLine savedOrderLine = orderLineServiceImpl.save(expectedOrderLine);

        verify(orderLineRepository, times(1)).save(expectedOrderLine);
        assertEquals(expectedOrderLine, savedOrderLine);
    }

    @Test
    public void findById() {
        OrderLine expectedOrderLine = OrderLineTestDataBuilder.buildOrderLine1().build();

        when(orderLineRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(expectedOrderLine));
        OrderLine foundOrderLine = this.orderLineServiceImpl.findById(1L);

        verify(orderLineRepository, times(1)).findById(1L);
    }

    @Test
    public void findAll() {
        List<OrderLine> expectedOrderLines = new ArrayList<>();
        OrderLine orderLine1 = OrderLineTestDataBuilder.buildOrderLine1().build();
        OrderLine orderLine2 = OrderLineTestDataBuilder.buildOrderLine2().build();
        expectedOrderLines.add(orderLine1);
        expectedOrderLines.add(orderLine2);

        when(orderLineRepository.findAll()).thenReturn(expectedOrderLines);
        List<OrderLine> foundOrderLines = this.orderLineServiceImpl.findAll();

        verify(orderLineRepository, times(1)).findAll();
        assertEquals(expectedOrderLines.size(), foundOrderLines.size());
    }

    @Test
    public void findByUser() {
    }

    @Test
    public void findByUserId() {
    }

    @Test
    public void delete() {
        OrderLine expectedOrderLine = OrderLineTestDataBuilder.buildOrderLine1().build();
        orderLineServiceImpl.delete(expectedOrderLine);

        verify(orderLineRepository, times(1)).delete(expectedOrderLine);
    }

    @Test
    public void deleteById() {
        OrderLine expectedOrderLine = OrderLineTestDataBuilder.buildOrderLine1().build();
        when(orderLineRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(expectedOrderLine));

        orderLineServiceImpl.deleteById(1L);

        verify(orderLineRepository, times(1)).findById(1L);
        verify(orderLineRepository, times(1)).delete(expectedOrderLine);

    }

    @Test
    public void findCurrentCartByUserId() {


    }
}
