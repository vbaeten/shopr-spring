package com.realdolmen.backend.model.enums;

public enum GameGenreEnum
{
FPS("fps"), RTS("rts"), TPS("tps"), MOBILE("mobile"), MMORPG("mmorpg"), RPG("rpg");


    private final String text;

    GameGenreEnum(final String text)
    {
        this.text = text;

    }

    @Override
    public String toString()
    {
        return text;
    }

    }
