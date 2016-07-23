package com.mauriciotogneri.jsonschema.definitions;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.schemas.Schema;

public class Definition
{
    private final String name;
    private final Schema schema;

    public Definition(String name, Schema schema)
    {
        this.name = name;
        this.schema = schema;
    }

    public JsonField json()
    {
        return new JsonField(name, schema.json());
    }
}