package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueString;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class Type implements Attribute
{
    private final PrimitiveType value;

    public Type(PrimitiveType value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("type", new JsonValueString(value.toString()));
    }
}