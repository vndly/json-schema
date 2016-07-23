package com.mauriciotogneri.jsonschema.json;

public class JsonField
{
    private final String name;
    private final JsonValue value;

    public JsonField(String name, JsonValue value)
    {
        this.name = name;
        this.value = value;
    }

    public String name()
    {
        return name;
    }

    public JsonValue value()
    {
        return value;
    }
}