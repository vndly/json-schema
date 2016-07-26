package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonArray;
import com.mauriciotogneri.jsonschema.json.JsonElement;
import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonPrimitive;
import com.mauriciotogneri.jsonschema.structures.ImmutableList;

import java.util.Arrays;
import java.util.List;

public class RequiredAttribute implements Attribute
{
    private final ImmutableList<JsonElement> values;

    public RequiredAttribute(String... values)
    {
        this(Arrays.asList(values));
    }

    public RequiredAttribute(List<String> values)
    {
        this.values = new ImmutableList<>();

        for (String value : values)
        {
            this.values.add(new JsonPrimitive(value));
        }
    }

    @Override
    public JsonField json()
    {
        return new JsonField("required", new JsonArray(values));
    }
}