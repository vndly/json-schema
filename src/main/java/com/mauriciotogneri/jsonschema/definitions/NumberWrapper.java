package com.mauriciotogneri.jsonschema.definitions;

public class NumberWrapper
{
    private final Number value;

    public NumberWrapper(Number value)
    {
        this.value = value;
    }

    public NumberWrapper(long value)
    {
        this.value = value;
    }

    public NumberWrapper(double value)
    {
        this.value = value;
    }

    public boolean isNegative()
    {
        return value.doubleValue() < 0;
    }

    public boolean isInteger()
    {
        return (value.longValue() == value.doubleValue());
    }

    public long intValue()
    {
        return value.longValue();
    }

    public double doubleValue()
    {
        return value.doubleValue();
    }
}