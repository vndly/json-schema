package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonArray;
import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValue;
import com.mauriciotogneri.jsonschema.json.JsonValueString;
import com.mauriciotogneri.jsonschema.structures.ImmutableList;

import java.util.Arrays;
import java.util.List;

public class Required implements Attribute
{
    private final ImmutableList<JsonValue> values;

    public Required(String... values)
    {
        this(Arrays.asList(values));
    }

    public Required(List<String> values)
    {
        this.values = new ImmutableList<>();

        for (String value : values)
        {
            this.values.add(new JsonValueString(value));
        }
    }

    @Override
    public JsonField json()
    {
        return new JsonField("required", new JsonArray(values));
    }
}