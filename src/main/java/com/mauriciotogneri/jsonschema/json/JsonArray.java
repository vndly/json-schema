package com.mauriciotogneri.jsonschema.json;

import com.mauriciotogneri.jsonschema.structures.ImmutableList;

public class JsonArray implements JsonValue
{
    private final ImmutableList<JsonValue> items;

    public JsonArray(ImmutableList<JsonValue> items)
    {
        this.items = items;
    }

    public JsonArray()
    {
        this.items = new ImmutableList<>();
    }

    public JsonArray add(JsonValue value)
    {
        return new JsonArray(items.add(value));
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (JsonValue value : items)
        {
            if (builder.length() != 0)
            {
                builder.append(",");
            }

            builder.append(value.toString());
        }

        return String.format("[%s]", builder.toString());
    }
}