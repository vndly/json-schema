package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonPrimitive;

public class RefAttribute implements Attribute
{
    private final String value;

    public RefAttribute(String value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("$ref", new JsonPrimitive(value));
    }
}