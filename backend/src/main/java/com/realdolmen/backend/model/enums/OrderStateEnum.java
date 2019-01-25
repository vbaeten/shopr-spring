package com.realdolmen.backend.model.enums;

public enum OrderStateEnum
{
PENDING("pending"), COMPLETED("completed");

    private final String text;

    OrderStateEnum(final String text)
    {
        this.text = text;

    }

    @Override
    public String toString()
    {
        return text;
    }


}
