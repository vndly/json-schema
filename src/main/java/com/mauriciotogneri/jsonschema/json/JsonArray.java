package com.mauriciotogneri.jsonschema.json;

import com.mauriciotogneri.jsonschema.structures.ImmutableList;

public class JsonArray implements JsonElement
{
    private final ImmutableList<JsonElement> items;

    public JsonArray(ImmutableList<JsonElement> items)
    {
        this.items = items;
    }

    public JsonArray()
    {
        this.items = new ImmutableList<>();
    }

    public JsonArray add(JsonElement value)
    {
        return new JsonArray(items.add(value));
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (JsonElement value : items)
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