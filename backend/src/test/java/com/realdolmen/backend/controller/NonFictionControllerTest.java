package com.realdolmen.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.realdolmen.backend.data.NonFictionTestDataBuilder;
import com.realdolmen.backend.dto.NonFictionDto;
import com.realdolmen.backend.facade.NonFictionFacade;
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
public class NonFictionControllerTest {

    @Mock
    NonFictionFacade facade;

    @InjectMocks
    NonFictionController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new NonFictionController(facade);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getNonNonFictionBooks() throws Exception {
        mockMvc.perform(get("/nonfiction/list"))
                .andExpect(status().isOk());

        verify(facade, times(1)).findAll();
    }

    @Test
    public void addNonFiction() throws Exception {
        NonFictionDto nonFictionDto = NonFictionTestDataBuilder.buildNonFictionBookDto().build();

        String nonFictionDtoString = new ObjectMapper().writeValueAsString(nonFictionDto);

        mockMvc.perform(post("/nonfiction/add")
                .content(nonFictionDtoString)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }

    @Test
    public void getNonFictionById() throws Exception {

        NonFictionDto nonfictionDto = NonFictionTestDataBuilder.buildNonFictionBookDto().build();

        when(facade.findById(anyLong())).thenReturn(nonfictionDto);

        mockMvc.perform(get("/nonfiction/1")).andExpect(status().isOk());

        verify(facade, times(1)).findById(anyLong());

    }
}
