package com.realdolmen.backend.model.enums;

public enum UserRoleEnum
{
USER("user"), ADMIN("admin");

    private final String text;

    UserRoleEnum(final String text)
    {
        this.text = text;

    }

    @Override
    public String toString()
    {
        return text;
    }


}
