package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.json.JsonValue;

public class RootSchema implements AbstractSchema
{
    private final Schema schema;

    public RootSchema(AbstractSchema abstractSchema)
    {
        this.schema = abstractSchema.schema().root();
    }

    public RootSchema id(String id)
    {
        return new RootSchema(schema.id(id));
    }

    @Override
    public Schema schema()
    {
        return schema;
    }

    @Override
    public JsonValue json()
    {
        return schema.json();
    }

    @Override
    public String toString()
    {
        return schema.toString();
    }
}