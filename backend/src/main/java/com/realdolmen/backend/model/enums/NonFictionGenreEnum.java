package com.realdolmen.backend.model.enums;

public enum NonFictionGenreEnum
{
RELIGION("religion"), BIOGRAPHY("biography"), FOOD("food"), TRAVEL("travel");

    private final String text;

    NonFictionGenreEnum(final String text)
    {
        this.text = text;

    }

    @Override
    public String toString()
    {
        return text;
    }


}
