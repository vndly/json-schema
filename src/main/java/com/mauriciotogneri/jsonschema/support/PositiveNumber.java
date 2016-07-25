package com.mauriciotogneri.jsonschema.support;

public class PositiveNumber extends Number
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

    @Override
    public int intValue()
    {
        return value.intValue();
    }

    @Override
    public long longValue()
    {
        return value.longValue();
    }

    @Override
    public float floatValue()
    {
        return value.floatValue();
    }

    @Override
    public double doubleValue()
    {
        return value.doubleValue();
    }

    @Override
    public String toString()
    {
        return value.toString();
    }
}