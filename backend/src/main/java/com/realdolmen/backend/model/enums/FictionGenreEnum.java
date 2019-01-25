package com.realdolmen.backend.model.enums;

public enum FictionGenreEnum
{
SCIENCEFICTION("sciencefiction"), DETECTIVE("detective"), DRAMA("drama");

    private final String text;

    FictionGenreEnum(final String text)
    {
        this.text = text;

    }

    @Override
    public String toString()
    {
        return text;
    }


}
