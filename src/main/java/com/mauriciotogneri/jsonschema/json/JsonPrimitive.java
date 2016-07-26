package com.mauriciotogneri.jsonschema.json;

public class JsonPrimitive implements JsonElement
{
    private final Object value;

    public JsonPrimitive(String value)
    {
        this.value = value;
    }

    public JsonPrimitive(Number value)
    {
        this.value = value;
    }

    public JsonPrimitive(Boolean value)
    {
        this.value = value;
    }

    public JsonPrimitive(Character value)
    {
        this.value = value.toString();
    }

    @Override
    public String toString()
    {
        if (value.getClass().equals(String.class))
        {
            return String.format("\"%s\"", value.toString());
        }
        else
        {
            return value.toString();
        }
    }
}