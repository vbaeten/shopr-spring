package com.realdolmen.backend.controller;

import com.realdolmen.backend.service.GameService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GameControllerTest {

    @Mock
    GameService gameService;

    GameController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new GameController(gameService);
    }

    @Test
    public void getGames() {
    }

    @Test
    public void addGame() {
    }

    @Test
    public void getGame() {
    }
}
