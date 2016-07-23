package com.mauriciotogneri.jsonschema.definitions;

public class PositiveDouble
{
    private final Double value;

    public PositiveDouble(double value)
    {
        if (value < 0)
        {
            throw new RuntimeException(String.format("Invalid positive integer: %f", value));
        }

        this.value = value;
    }
}