package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.properties.Properties;
import com.mauriciotogneri.jsonschema.properties.Type;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class SchemaNull extends Schema
{
    public SchemaNull()
    {
        super(new Properties().add(new Type(PrimitiveType.NULL)));
    }
}