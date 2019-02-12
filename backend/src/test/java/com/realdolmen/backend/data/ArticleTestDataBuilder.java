package com.realdolmen.backend.data;

import com.realdolmen.backend.domain.Game;
import com.realdolmen.backend.domain.GameGenre;
import com.realdolmen.backend.domain.Lp;
import com.realdolmen.backend.domain.LpGenre;

import java.math.BigDecimal;

public class ArticleTestDataBuilder {

    public static Game.Builder buildGameArticleNFS(){
        return Game.builder()
                .gameGenre(GameGenre.RACE)
                .minimumAge(10)
                .price(new BigDecimal(40))
                .publisher("EA")
                .supplierId("dsf6546dfs")
                .title("Need For Spiet")
                .type("game");
    }

    public static Game.Builder buildGameArticleGTA(){
        return Game.builder()
                .gameGenre(GameGenre.RACE)
                .minimumAge(18)
                .price(new BigDecimal(70))
                .publisher("Rockstar")
                .supplierId("rckstr6546dGta")
                .title("Grand Theft Auto X")
                .type("game");
    }

    public static Lp.Builder buildLpArticle(){
        return Lp.builder()
                .lpGenre(LpGenre.HIPHOP)
                .price(new BigDecimal(10))
                .publisher("YMCMB")
                .supplierId("YmCmB15894516gd")
                .title("The Carter X")
                .type("lp");
    }

}
