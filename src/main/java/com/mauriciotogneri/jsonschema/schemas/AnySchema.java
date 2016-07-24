package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.attributes.Attributes;
import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.json.JsonValue;

public class AnySchema implements AbstractSchema
{
    private final Schema schema;

    private AnySchema(Schema schema)
    {
        this.schema = schema;
    }

    public AnySchema()
    {
        this(new Schema(new Definitions(), new Attributes()));
    }

    public AnySchema title(String title)
    {
        return new AnySchema(schema.title(title));
    }

    public AnySchema description(String description)
    {
        return new AnySchema(schema.description(description));
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