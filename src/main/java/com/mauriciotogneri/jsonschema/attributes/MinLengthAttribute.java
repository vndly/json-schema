package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonPrimitive;
import com.mauriciotogneri.jsonschema.support.PositiveNumber;

public class MinLengthAttribute implements Attribute
{
    private final PositiveNumber value;

    public MinLengthAttribute(PositiveNumber value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("minLength", new JsonPrimitive(value));
    }
}