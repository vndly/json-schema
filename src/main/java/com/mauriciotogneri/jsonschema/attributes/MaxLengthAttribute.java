package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonPrimitive;
import com.mauriciotogneri.jsonschema.support.PositiveNumber;

public class MaxLengthAttribute implements Attribute
{
    private final PositiveNumber value;

    public MaxLengthAttribute(PositiveNumber value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("maxLength", new JsonPrimitive(value));
    }
}