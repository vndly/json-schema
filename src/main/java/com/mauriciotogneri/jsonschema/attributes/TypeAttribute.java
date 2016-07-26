package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonPrimitive;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class TypeAttribute implements Attribute
{
    private final PrimitiveType value;

    public TypeAttribute(PrimitiveType value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("type", new JsonPrimitive(value.toString()));
    }
}