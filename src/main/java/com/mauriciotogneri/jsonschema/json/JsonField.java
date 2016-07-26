package com.mauriciotogneri.jsonschema.json;

public class JsonField
{
    private final String name;
    private final JsonElement value;

    public JsonField(String name, JsonElement value)
    {
        this.name = name;
        this.value = value;
    }

    public String name()
    {
        return name;
    }

    public JsonElement value()
    {
        return value;
    }
}