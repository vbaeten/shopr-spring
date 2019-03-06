package com.realdolmen.backend.controller;

import com.realdolmen.backend.data.GameTestDataBuilder;
import com.realdolmen.backend.dto.GameDto;
import com.realdolmen.backend.facade.GameFacade;
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
public class GameControllerTest {

    @Mock
    GameFacade facade;

    @InjectMocks
    GameController controller;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new GameController(facade);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getGames() throws Exception{
        mockMvc.perform(get("/game/list"))
                .andExpect(status().isOk());

        verify(facade, times(1)).findAll();
    }

    @Test
    public void addGame() {
    }

    @Test
    public void getGameById() throws Exception {

        GameDto gameDto = GameTestDataBuilder.buildGameZeldaDTO().build();

        when(facade.findById(anyLong())).thenReturn(gameDto);

        mockMvc.perform(get("/game/1")).andExpect(status().isOk());

        verify(facade, times(1)).findById(anyLong());

    }
}
