package com.mauriciotogneri.jsonschema.json;

import com.mauriciotogneri.jsonschema.structures.ImmutableMap;

import java.util.Map.Entry;

public class JsonObject implements JsonValue
{
    private final ImmutableMap<String, JsonValue> fields;

    private JsonObject(ImmutableMap<String, JsonValue> fields)
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
        return new JsonObject(fields.put(name, new JsonValueString(value)));
    }

    public JsonObject add(String name, long value)
    {
        return new JsonObject(fields.put(name, new JsonValueNumber(value)));
    }

    public JsonObject add(String name, double value)
    {
        return new JsonObject(fields.put(name, new JsonValueNumber(value)));
    }

    public JsonObject add(String name, boolean value)
    {
        return new JsonObject(fields.put(name, new JsonValueBoolean(value)));
    }

    public JsonObject add(String name, JsonObject value)
    {
        return new JsonObject(fields.put(name, value));
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (Entry<String, JsonValue> entry : fields.entries())
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