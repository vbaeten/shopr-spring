package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.repository.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class OrderServiceImplTest {

    OrderServiceImpl orderService;

    //the dependency
    @Mock
    OrderRepository orderRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        orderService = new OrderServiceImpl(orderRepository);
    }

    @Test
    public void save() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAll() throws Exception {
        //create data
        Order order1 = new Order();
        Order order2 = new Order();
        List<Order> orderData = Arrays.asList(order1, order2);

        when(orderService.findAll()).thenReturn(orderData);

        List<Order> orders = orderService.findAll();

        assertEquals(orders.size(), 2);
        //check this is called 1 time
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    public void delete() {
    }

    @Test
    public void findByUserId() {
    }
}
