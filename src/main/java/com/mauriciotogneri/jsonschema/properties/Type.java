package com.mauriciotogneri.jsonschema.properties;

import com.mauriciotogneri.jsonschema.types.PrimitiveType;
import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueString;

public class Type implements Property
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