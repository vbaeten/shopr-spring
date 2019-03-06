package com.realdolmen.backend.service;

import com.realdolmen.backend.data.GameTestDataBuilder;
import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.repository.GameRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class GameServiceImplTest {

    @Mock
    private GameRepository gameRepository;
    @InjectMocks
    private GameServiceImpl gameService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save() {
        Game expectedGame = GameTestDataBuilder.buildGameZelda().build();

        when(gameRepository.save(any())).thenReturn(expectedGame);

        Game savedGame = this.gameService.save(expectedGame);

        verify(gameRepository, times(1)).save(expectedGame);
        assertEquals(expectedGame, savedGame);
    }

    @Test
    public void findById() {
        Game expectedGame = GameTestDataBuilder.buildGameZelda().build();
        when(gameRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(expectedGame));
        Game foundGame = this.gameService.findById(1L);

        verify(gameRepository, times(1)).findById(1L);
        assertEquals(expectedGame.getPrice(), foundGame.getPrice(), 0.01);
    }

    @Test
    public void findAll() throws Exception {
        List<Game> expectedGames = new ArrayList<>();
        Game fiction1 = GameTestDataBuilder.buildGameZelda().build();
        expectedGames.add(fiction1);

        when(gameRepository.findAll()).thenReturn(expectedGames);

        List<Game> actualGames = gameService.findAll();

        verify(gameRepository, times(1)).findAll();
        assertEquals(expectedGames.size(), actualGames.size());
    }

    @Test
    public void delete() {
        Game fiction = GameTestDataBuilder.buildGameZelda().build();
        gameService.delete(fiction);

        verify(gameRepository, times(1)).delete(fiction);
    }
}
