package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.attributes.Attributes;
import com.mauriciotogneri.jsonschema.attributes.Type;
import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class SchemaNull extends Schema
{
    public SchemaNull()
    {
        super(new Definitions(), new Attributes().add(new Type(PrimitiveType.NULL)));
    }
}