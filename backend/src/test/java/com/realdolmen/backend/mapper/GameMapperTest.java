package com.realdolmen.backend.mapper;

import com.realdolmen.backend.data.GameTestDataBuilder;
import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.dto.GameDto;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GameMapperTest {

    private GameMapper gameMapper = Mappers.getMapper(GameMapper.class);

    @Test
    public void gameToUserDTO() throws Exception {
        Game game = GameTestDataBuilder.buildGameZelda().build();
        GameDto gameDto = gameMapper.gameToGameDto(game);

        assertEquals(game.getMinAge(), gameDto.getMinAge());
        assertEquals(game.getId(), gameDto.getId());
    }

    @Test
    public void gameDtoToGame() throws Exception {
        GameDto gameDto = GameTestDataBuilder.buildGameZeldaDTO().build();
        Game game = gameMapper.gameDtoToGame(gameDto);

        assertEquals(gameDto.getGameGenre(), game.getGameGenre());
        assertEquals(gameDto.getId(), game.getId());
    }

    @Test
    public void testGameShouldAssertNull() {
        Game game = gameMapper.gameDtoToGame(null);
        assertNull(game);
    }
    @Test
    public void testGameDtoShouldAssertNull() {
        GameDto gameDto = gameMapper.gameToGameDto(null);
        assertNull(gameDto);
    }

}
