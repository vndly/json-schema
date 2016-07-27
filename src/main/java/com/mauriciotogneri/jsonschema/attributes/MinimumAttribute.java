package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonPrimitive;

public class MinimumAttribute implements Attribute
{
    private final Number value;

    public MinimumAttribute(Number value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("minimum", new JsonPrimitive(value));
    }
}