package com.realdolmen.backend.controller;

import com.realdolmen.backend.data.FictionTestDataBuilder;
import com.realdolmen.backend.dto.FictionDto;
import com.realdolmen.backend.facade.FictionFacade;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class FictionControllerTest {

    @Mock
    FictionFacade facade;

    @InjectMocks
    FictionController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new FictionController(facade);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getFictionBooks() throws Exception {
        mockMvc.perform(get("/fiction/list"))
                .andExpect(status().isOk());

        verify(facade, times(1)).findAll();
    }

    @Test
    public void addFiction() {
    }

    @Test
    public void getFictionById() throws Exception {

        FictionDto fictionDto = FictionTestDataBuilder.buildFictionBookDto().build();

        when(facade.findById(anyLong())).thenReturn(fictionDto);

        mockMvc.perform(get("/fiction/1")).andExpect(status().isOk());

        verify(facade, times(1)).findById(anyLong());

    }
}
