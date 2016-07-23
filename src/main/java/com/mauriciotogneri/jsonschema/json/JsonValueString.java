package com.mauriciotogneri.jsonschema.json;

public class JsonValueString implements JsonValue
{
    private final String value;

    public JsonValueString(String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return String.format("\"%s\"", value);
    }
}