package com.realdolmen.backend.facade;

import com.realdolmen.backend.data.GameTestDataBuilder;
import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.dto.GameDto;
import com.realdolmen.backend.mapper.GameMapper;
import com.realdolmen.backend.service.GameService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GameFacadeTest {

    @InjectMocks
    private GameFacade gameFacade;

    @Mock
    private GameService gameService;
    @Mock
    private GameMapper gameMapper;

    private Game game;
    private GameDto gameDto;



    @Before
    public void setUp() {
        game = GameTestDataBuilder.buildGameZelda().build();
        gameDto = GameTestDataBuilder.buildGameZeldaDTO().build();
    }

    @Test
    public void findAll() {
        this.gameFacade.findAll();
        verify(gameService, times(1)).findAll();
    }

    @Test
    public void findById() {
        when(gameService.findById(1L)).thenReturn(game);
        when(gameMapper.gameToGameDto(game)).thenReturn(gameDto);

        GameDto gameDtoResult;
        gameDtoResult = gameFacade.findById(1L);

        assertNotNull(gameDtoResult);
        assertEquals(game.getPrice(), gameDtoResult.getPrice(), 0.01);

        verify(gameService, times(1)).findById(any());
    }

    @Test
    public void create() {
        gameFacade.create(gameDto);
        verify(gameService, times(1)).save(any());
    }
}
