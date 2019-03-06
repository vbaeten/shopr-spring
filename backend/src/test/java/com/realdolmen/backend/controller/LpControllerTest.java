package com.realdolmen.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realdolmen.backend.data.LpTestDataBuilder;
import com.realdolmen.backend.dto.LpDto;
import com.realdolmen.backend.facade.LpFacade;
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

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class LpControllerTest {

    @Mock
    LpFacade facade;

    @InjectMocks
    LpController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new LpController(facade);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getLps() throws Exception {
        mockMvc.perform(get("/lp/list"))
                .andExpect(status().isOk());

        verify(facade, times(1)).findAll();
    }

    @Test
    public void addLp() throws Exception {
        LpDto lpDto = LpTestDataBuilder.buildLpDtoHelloComputer().build();

        String lpDtoString = new ObjectMapper().writeValueAsString(lpDto);

        mockMvc.perform(post("/lp/add")
                .content(lpDtoString)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }

    @Test
    public void getLpById() throws Exception {

        LpDto lpDto = LpTestDataBuilder.buildLpDtoHelloComputer().build();

        when(facade.findById(anyLong())).thenReturn(lpDto);

        mockMvc.perform(get("/lp/1")).andExpect(status().isOk());

        verify(facade, times(1)).findById(anyLong());

    }
}
