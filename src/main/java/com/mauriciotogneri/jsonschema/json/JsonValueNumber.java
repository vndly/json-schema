package com.mauriciotogneri.jsonschema.json;

import com.mauriciotogneri.jsonschema.support.NumberWrapper;

public class JsonValueNumber implements JsonValue
{
    private final NumberWrapper value;

    public JsonValueNumber(NumberWrapper value)
    {
        this.value = value;
    }

    public JsonValueNumber(long value)
    {
        this(new NumberWrapper(value));
    }

    public JsonValueNumber(double value)
    {
        this(new NumberWrapper(value));
    }

    @Override
    public String toString()
    {
        return value.isInteger() ? String.valueOf(value.intValue()) : String.valueOf(value.doubleValue());
    }
}