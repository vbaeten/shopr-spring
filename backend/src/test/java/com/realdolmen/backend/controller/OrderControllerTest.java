package com.realdolmen.backend.controller;

import com.realdolmen.backend.data.OrderTestDataBuilder;
import com.realdolmen.backend.dto.OrderDto;
import com.realdolmen.backend.facade.OrderFacade;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

    @Mock
    OrderFacade facade;

    @InjectMocks
    OrderController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new OrderController(facade);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void sendToOrder() {
        OrderDto orderDto = OrderTestDataBuilder.buildOrderDto1().build();
    }

    @Test
    public void findByUserId() {
    }
}
