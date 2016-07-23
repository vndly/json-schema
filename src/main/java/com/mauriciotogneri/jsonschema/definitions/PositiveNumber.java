package com.mauriciotogneri.jsonschema.definitions;

public class PositiveNumber
{
    private final NumberWrapper value;

    public PositiveNumber(Number value)
    {
        if (value.doubleValue() < 0)
        {
            throw new RuntimeException(String.format("Invalid positive number: %s", value.toString()));
        }

        this.value = new NumberWrapper(value);
    }

    public NumberWrapper value()
    {
        return value;
    }
}