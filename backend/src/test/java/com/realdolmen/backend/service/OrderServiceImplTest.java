package com.realdolmen.backend.service;

import com.realdolmen.backend.data.OrderTestDataBuilder;
import com.realdolmen.backend.data.UserTestDataBuilder;
import com.realdolmen.backend.domain.Order;
import com.realdolmen.backend.domain.User;
import com.realdolmen.backend.repository.OrderRepository;
import org.junit.Before;
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
public class OrderServiceImplTest {

    @InjectMocks
    OrderServiceImpl orderService;
    @Mock
    OrderRepository orderRepository;

    private Order order;

    @Test
    public void shouldMockService(){
        assertNotNull(orderService);
    }

    @Before
    public void init() {}

    @Test
    public void save() {
        Order expectedOrder = OrderTestDataBuilder.buildOrder1().build();

        when(orderRepository.save(any())).thenReturn(expectedOrder);

        Order savedOrder = this.orderService.save(expectedOrder);

        verify(orderRepository, times(1)).save(expectedOrder);
        assertEquals(expectedOrder, savedOrder);
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAll() throws Exception {
        List<Order> expectedOrders = new ArrayList<>();
        Order order1 = OrderTestDataBuilder.buildOrder1().build();
        Order order2 = OrderTestDataBuilder.buildOrder2().build();

        when(orderRepository.findAll()).thenReturn(expectedOrders);

        List<Order> foundOrders = this.orderRepository.findAll();

        verify(orderRepository, times(1)).findAll();
        assertEquals(expectedOrders.size(), foundOrders.size());
    }

    @Test
    public void delete() {
        Order order = OrderTestDataBuilder.buildOrder1().build();
        orderService.delete(order);

        verify(orderRepository, times(1)).delete(order);
    }

    @Test
    public void findByUserId() {
        User user = UserTestDataBuilder.buildUserBernadetteSanz().build();
        Order order = OrderTestDataBuilder.buildOrder1().build();
        List<Order> expectedOrders = new ArrayList<>();
        expectedOrders.add(order);

        when(orderRepository.findOrdersByUserId(any())).thenReturn(expectedOrders);

        List<Order> foundOrders = orderService.findByUserId(1L);

        verify(orderRepository, times(1)).findOrdersByUserId(1L);
        assertEquals(user.getFirstName(), order.getUser().getFirstName()); }
}
