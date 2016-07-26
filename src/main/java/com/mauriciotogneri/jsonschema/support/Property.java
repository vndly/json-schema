package com.mauriciotogneri.jsonschema.support;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.schemas.Schema;

public class Property
{
    private final String name;
    private final Schema schema;

    public Property(String name, Schema schema)
    {
        this.name = name;
        this.schema = schema;
    }

    public JsonField json()
    {
        return new JsonField(name, schema.json());
    }
}