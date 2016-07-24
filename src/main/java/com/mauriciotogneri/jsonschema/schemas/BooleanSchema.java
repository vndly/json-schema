package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.attributes.Attributes;
import com.mauriciotogneri.jsonschema.attributes.Type;
import com.mauriciotogneri.jsonschema.definitions.Definition;
import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.json.JsonValue;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class BooleanSchema implements AbstractSchema
{
    private final Schema schema;

    private BooleanSchema(Schema schema)
    {
        this.schema = schema;
    }

    public BooleanSchema()
    {
        this(new Schema(new Definitions(), new Attributes().add(new Type(PrimitiveType.BOOLEAN))));
    }

    public BooleanSchema definition(Definition definition)
    {
        return new BooleanSchema(schema.definition(definition));
    }

    public BooleanSchema title(String title)
    {
        return new BooleanSchema(schema.title(title));
    }

    public BooleanSchema description(String description)
    {
        return new BooleanSchema(schema.description(description));
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