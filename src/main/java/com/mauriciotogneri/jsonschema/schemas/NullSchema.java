package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.attributes.Attributes;
import com.mauriciotogneri.jsonschema.attributes.Type;
import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.json.JsonValue;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class NullSchema implements AbstractSchema
{
    private final Schema schema;

    private NullSchema(Schema schema)
    {
        this.schema = schema;
    }

    public NullSchema()
    {
        this(new Schema(new Definitions(), new Attributes().add(new Type(PrimitiveType.NULL))));
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