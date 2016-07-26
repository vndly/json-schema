package com.mauriciotogneri.jsonschema.json;

import com.mauriciotogneri.jsonschema.structures.ImmutableMap;

import java.util.Map.Entry;

public class JsonObject implements JsonElement
{
    private final ImmutableMap<String, JsonElement> fields;

    private JsonObject(ImmutableMap<String, JsonElement> fields)
    {
        this.fields = fields;
    }

    public JsonObject()
    {
        this.fields = new ImmutableMap<>();
    }

    public JsonObject add(JsonField field)
    {
        return new JsonObject(fields.put(field.name(), field.value()));
    }

    public JsonObject add(String name, String value)
    {
        return new JsonObject(fields.put(name, new JsonPrimitive(value)));
    }

    public JsonObject add(String name, long value)
    {
        return new JsonObject(fields.put(name, new JsonPrimitive(value)));
    }

    public JsonObject add(String name, double value)
    {
        return new JsonObject(fields.put(name, new JsonPrimitive(value)));
    }

    public JsonObject add(String name, boolean value)
    {
        return new JsonObject(fields.put(name, new JsonPrimitive(value)));
    }

    public JsonObject add(String name, JsonObject value)
    {
        return new JsonObject(fields.put(name, value));
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (Entry<String, JsonElement> entry : fields.entries())
        {
            if (builder.length() != 0)
            {
                builder.append(",");
            }

            builder.append(String.format("\"%s\":%s", entry.getKey(), entry.getValue().toString()));
        }

        return String.format("{%s}", builder.toString());
    }
}