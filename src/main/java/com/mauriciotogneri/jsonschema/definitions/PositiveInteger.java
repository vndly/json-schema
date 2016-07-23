package com.mauriciotogneri.jsonschema.definitions;

public class PositiveInteger
{
    private final Long value;

    public PositiveInteger(long value)
    {
        if (value < 0)
        {
            throw new RuntimeException(String.format("Invalid positive integer: %d", value));
        }

        this.value = value;
    }

    public long value()
    {
        return value;
    }
}