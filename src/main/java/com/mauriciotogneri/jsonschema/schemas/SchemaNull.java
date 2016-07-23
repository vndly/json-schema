package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class SchemaNull extends Schema
{
    private final PrimitiveType type;

    public SchemaNull()
    {
        this.type = PrimitiveType.NULL;
    }
}