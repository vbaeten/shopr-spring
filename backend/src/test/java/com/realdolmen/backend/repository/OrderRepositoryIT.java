package com.realdolmen.backend.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryIT {

    @Autowired
    OrderRepository orderRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByUserId() throws Exception {
        orderRepository.findOrdersByUserId(1L);
    }
}
