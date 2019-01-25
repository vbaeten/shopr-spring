package com.realdolmen.backend.model.enums;

public enum LpGenreEnum
{
METAL("metal"), ROCK("rock"), DANCE("dance"), CLASSIC("classic"), FOLK("folk"), POP("pop");

private final String text;

LpGenreEnum(final String text)
{
    this.text = text;

}

@Override
    public String toString()
{
    return text;
}

}
