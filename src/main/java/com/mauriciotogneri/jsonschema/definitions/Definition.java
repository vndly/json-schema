package com.mauriciotogneri.jsonschema.definitions;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.schemas.AbstractSchema;

public class Definition
{
    private final String name;
    private final AbstractSchema schema;

    public Definition(String name, AbstractSchema schema)
    {
        this.name = name;
        this.schema = schema;
    }

    public String name()
    {
        return name;
    }

    public JsonField json()
    {
        return new JsonField(name, schema.json());
    }
}