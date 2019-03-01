package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.domain.GameGenre;
import com.realdolmen.backend.dto.GameDto;

public class GameTestDataBuilder {

    public static Game.GameBuilder buildGameZelda() {
        return Game.builder().id(1L).title("Zelda").gameGenre(GameGenre.RPG).minAge(8).supplier("Dreamland").publisher("Nintendo").price(50);
    }

    public static GameDto.GameDtoBuilder buildGameZeldaDTO() {
        return GameDto.builder().id(1L).title("Zelda").gameGenre(GameGenre.RPG).minAge(8).supplier("Dreamland").publisher("Nintendo").price(50);
    }
}
