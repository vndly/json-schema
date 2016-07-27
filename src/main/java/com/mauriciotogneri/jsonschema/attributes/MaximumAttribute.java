package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonPrimitive;

public class MaximumAttribute implements Attribute
{
    private final Number value;

    public MaximumAttribute(Number value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("maximum", new JsonPrimitive(value));
    }
}