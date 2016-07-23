package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.attributes.Attributes;
import com.mauriciotogneri.jsonschema.definitions.Definitions;

public class SchemaAny extends Schema
{
    // TODO: can it have title and description?

    public SchemaAny()
    {
        super(new Definitions(), new Attributes());
    }
}