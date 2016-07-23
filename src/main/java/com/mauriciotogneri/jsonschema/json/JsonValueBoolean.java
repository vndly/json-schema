package com.mauriciotogneri.jsonschema.json;

public class JsonValueBoolean implements JsonValue
{
    private final Boolean value;

    public JsonValueBoolean(boolean value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return value.toString();
    }
}