package com.mauriciotogneri.jsonschema.json;

public class JsonValueNumber implements JsonValue
{
    private final Number value;

    public JsonValueNumber(long value)
    {
        this.value = value;
    }

    public JsonValueNumber(double value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return value.toString(); // TODO: if number is double but *.0 then render as integer
    }
}