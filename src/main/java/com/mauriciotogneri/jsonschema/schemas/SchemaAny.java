package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.properties.Properties;

public class SchemaAny extends Schema
{
    // TODO: can it have title and description?

    private SchemaAny(Properties properties)
    {
        super(properties);
    }

    public SchemaAny()
    {
        super(new Properties());
    }
}