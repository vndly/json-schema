package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.attributes.Attributes;
import com.mauriciotogneri.jsonschema.attributes.TypeAttribute;
import com.mauriciotogneri.jsonschema.definitions.Definition;
import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.json.JsonElement;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class NumberSchema implements AbstractSchema
{
    // TODO: cannot set exclusiveMinimum without setting minimum
    // TODO: cannot set exclusiveMaximum without setting maximum
    // TODO: minimum cannot be bigger than maximum

    private final Schema schema;

    private NumberSchema(Schema schema)
    {
        this.schema = schema;
    }

    public NumberSchema()
    {
        this(new Schema(new Definitions(), new Attributes().add(new TypeAttribute(PrimitiveType.NUMBER))));
    }

    public NumberSchema definition(Definition definition)
    {
        return new NumberSchema(schema.definition(definition));
    }

    public NumberSchema title(String title)
    {
        return new NumberSchema(schema.title(title));
    }

    public NumberSchema description(String description)
    {
        return new NumberSchema(schema.description(description));
    }

    public NumberSchema multipleOf(double value)
    {
        return new NumberSchema(schema.multipleOf(value));
    }

    public NumberSchema minimum(double minimum)
    {
        return new NumberSchema(schema.minimum(minimum));
    }

    public NumberSchema maximum(double maximum)
    {
        return new NumberSchema(schema.maximum(maximum));
    }

    public NumberSchema exclusiveMinimum(boolean minimum)
    {
        return new NumberSchema(schema.exclusiveMinimum(minimum));
    }

    public NumberSchema exclusiveMaximum(boolean maximum)
    {
        return new NumberSchema(schema.exclusiveMaximum(maximum));
    }

    @Override
    public Schema schema()
    {
        return schema;
    }

    @Override
    public JsonElement json()
    {
        return schema.json();
    }

    @Override
    public String toString()
    {
        return schema.toString();
    }
}