package com.mauriciotogneri.jsonschema.json;

public class JsonValueNumber implements JsonValue
{
    private final Number value;

    public JsonValueNumber(Number value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return value.toString();
    }
}