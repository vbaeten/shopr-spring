package com.realdolmen.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realdolmen.backend.data.OrderLineTestDataBuilder;
import com.realdolmen.backend.dto.OrderLineDto;
import com.realdolmen.backend.facade.OrderLineFacade;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    public void addToCart() throws Exception {
        OrderLineDto orderLineDto = OrderLineTestDataBuilder.buildOrderLine2Dto().build();

        String olString = new ObjectMapper().writeValueAsString(orderLineDto);

        mockMvc.perform(post("/orderline/add")
                .content(olString)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }

    @Test
    public void geOrderLineByUserId() throws Exception {

    }

    @Test
    public void findCurrentCartByOrderLineId() {
    }

    @Test
    public void getOrderLinesByUserId() throws Exception {
        OrderLineDto orderLine = OrderLineTestDataBuilder.buildOrderLine1Dto().build();


        mockMvc.perform(get("/orderline/list/1"))
                .andExpect(status().isOk());

        verify(facade, times(1)).findByUserId(1L);
    }

    @Test
    public void deleteOrderLine() throws Exception {
        mockMvc.perform(delete("/orderline/delete"))
                .andExpect(status().isOk());

        verify(facade, times(1)).deleteOrderLine(any());
    }
}
