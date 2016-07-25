package com.mauriciotogneri.jsonschema.support;

public class PositiveNumber
{
    private final Number value;

    public PositiveNumber(Number value)
    {
        if (value.doubleValue() < 0)
        {
            throw new RuntimeException(String.format("Invalid positive number: %s", value.toString()));
        }

        this.value = value;
    }

    public Number value()
    {
        return value;
    }
}