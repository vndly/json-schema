package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.attributes.Attributes;
import com.mauriciotogneri.jsonschema.attributes.TypeAttribute;
import com.mauriciotogneri.jsonschema.definitions.Definition;
import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.json.JsonValue;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class IntegerSchema implements AbstractSchema
{
    // TODO: cannot set exclusiveMinimum without setting minimum
    // TODO: cannot set exclusiveMaximum without setting maximum
    // TODO: minimum cannot be bigger than maximum

    private final Schema schema;

    private IntegerSchema(Schema schema)
    {
        this.schema = schema;
    }

    public IntegerSchema()
    {
        this(new Schema(new Definitions(), new Attributes().add(new TypeAttribute(PrimitiveType.INTEGER))));
    }

    public IntegerSchema definition(Definition definition)
    {
        return new IntegerSchema(schema.definition(definition));
    }

    public IntegerSchema title(String title)
    {
        return new IntegerSchema(schema.title(title));
    }

    public IntegerSchema description(String description)
    {
        return new IntegerSchema(schema.description(description));
    }

    public IntegerSchema multipleOf(long value)
    {
        return new IntegerSchema(schema.multipleOf(value));
    }

    public IntegerSchema minimum(long minimum)
    {
        return new IntegerSchema(schema.minimum(minimum));
    }

    public IntegerSchema maximum(long maximum)
    {
        return new IntegerSchema(schema.maximum(maximum));
    }

    public IntegerSchema exclusiveMinimum(boolean minimum)
    {
        return new IntegerSchema(schema.exclusiveMinimum(minimum));
    }

    public IntegerSchema exclusiveMaximum(boolean maximum)
    {
        return new IntegerSchema(schema.exclusiveMaximum(maximum));
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