package com.realdolmen.backend.service;

import com.realdolmen.backend.repository.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OrderServiceImplTest {

    OrderServiceImpl orderService;
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
    }

    @Test
    public void delete() {
    }

    @Test
    public void findByUserId() {
    }
}
