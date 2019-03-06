package com.realdolmen.backend.controller;

import com.realdolmen.backend.facade.OrderLineFacade;
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
public class ShoppingCartControllerTest {


    @Mock
    OrderLineFacade facade;

    @InjectMocks
    OrderLineController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new OrderLineController(facade);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getOrderLinesByUserId() throws Exception {
//        OrderLineDto orderLine = OrderLineTestDataBuilder.buildOrderLine1Dto().build();
//
//        mockMvc.perform(get("/cart/list/1"))
//                .andExpect(status().isOk());
//
//        verify(facade, times(1)).findByUserId(1L);
    }
}
