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
    private final List<String> values;

    public RequiredAttribute(String... values)
    {
        this(Arrays.asList(values));
    }

    public RequiredAttribute(List<String> values)
    {
        if (values.isEmpty())
        {
            throw new IllegalArgumentException("List of required properties cannot be empty");
        }

        this.values = values;
    }

    @Override
    public JsonField json()
    {
        ImmutableList<JsonElement> list = new ImmutableList<>();

        for (String value : values)
        {
            list = list.add(new JsonPrimitive(value));
        }

        return new JsonField("required", new JsonArray(list));
    }
}