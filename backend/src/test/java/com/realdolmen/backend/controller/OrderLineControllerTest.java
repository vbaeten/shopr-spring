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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class OrderLineControllerTest {

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
    public void addToCart() {
    }

    @Test
    public void geOrderLineByUserId() throws Exception {

    }

    @Test
    public void findCurrentCartByOrderLineId() {
    }

    @Test
    public void deleteOrderLine() throws Exception {
        mockMvc.perform(delete("/orderline/delete"))
                .andExpect(status().isOk());

        verify(facade, times(1)).deleteOrderLine(any());
    }
}
