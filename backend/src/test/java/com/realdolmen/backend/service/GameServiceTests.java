package com.realdolmen.backend.service;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.repository.GameReopsitory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static com.realdolmen.backend.data.ArticleTestDataBuilder.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTests {

    @InjectMocks
    GameServiceImpl gameService;
    @Mock
    GameReopsitory gameReopsitory;

    @Test
    @SuppressWarnings("unchecked")
    public void save() {

        Game expectedGame = buildGameArticleNFS().build();
        when(gameReopsitory.save(expectedGame)).thenReturn(expectedGame);
        Game savedGame = this.gameService.save(expectedGame);

        verify(gameReopsitory, times(1)).save(expectedGame);
        assertThat(savedGame, allOf(
                hasProperty("articleId", equalTo(expectedGame.getArticleId())),
                hasProperty("gameGenre", equalTo(expectedGame.getGameGenre())),
                hasProperty("minimumAge",equalTo(expectedGame.getMinimumAge())),
                hasProperty("price", equalTo(expectedGame.getPrice())),
                hasProperty("publisher", equalTo(expectedGame.getPublisher())),
                hasProperty("supplierId", equalTo(expectedGame.getSupplierId())),
                hasProperty("title", equalTo(expectedGame.getTitle())),
                hasProperty("type", equalTo(expectedGame.getType()))
                )
        );
    }

    @Test
    public void findById() {

        Game expectedGame = buildGameArticleNFS().build();
        expectedGame.setArticleId(10L);
        when(gameReopsitory.findById(expectedGame.getArticleId())).thenReturn(Optional.of(expectedGame));
        Game foundGame = this.gameService.findById(expectedGame.getArticleId());

        verify(gameReopsitory, times(1)).findById(expectedGame.getArticleId());
        assertEquals(expectedGame, foundGame);

    }

    @Test
    public void findAll() {



    }

    @Test
    public void delete() {
    }

}
