package com.realdolmen.backend.service;

import com.realdolmen.backend.repository.GameRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GameServiceImplTest {

    GameServiceImpl gameService;

    @Mock
    GameRepository gameRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        gameService = new GameServiceImpl(gameRepository);
    }

    @Test
    public void save() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void delete() {
    }
}
