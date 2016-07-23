package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.properties.Properties;

public class SchemaAny extends Schema
{
    // TODO: can it have title and description?

    public SchemaAny()
    {
        super(new Definitions(), new Properties());
    }
}