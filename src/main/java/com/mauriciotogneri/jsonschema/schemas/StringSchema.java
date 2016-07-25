package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.attributes.Attributes;
import com.mauriciotogneri.jsonschema.attributes.Enum;
import com.mauriciotogneri.jsonschema.attributes.Type;
import com.mauriciotogneri.jsonschema.definitions.Definition;
import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.json.JsonValue;
import com.mauriciotogneri.jsonschema.types.FormatType;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class StringSchema implements AbstractSchema
{
    private final Schema schema;

    private StringSchema(Schema schema)
    {
        this.schema = schema;
    }

    public StringSchema()
    {
        this(new Schema(new Definitions(), new Attributes().add(new Type(PrimitiveType.STRING))));
    }

    public StringSchema definition(Definition definition)
    {
        return new StringSchema(schema.definition(definition));
    }

    public StringSchema title(String title)
    {
        return new StringSchema(schema.title(title));
    }

    public StringSchema description(String description)
    {
        return new StringSchema(schema.description(description));
    }

    public StringSchema minLength(long minLength)
    {
        return new StringSchema(schema.minLength(minLength));
    }

    public StringSchema maxLength(long maxLength)
    {
        return new StringSchema(schema.maxLength(maxLength));
    }

    public StringSchema pattern(String pattern)
    {
        return new StringSchema(schema.pattern(pattern));
    }

    public StringSchema format(FormatType format)
    {
        return new StringSchema(schema.format(format));
    }

    public StringSchema enums(Enum enums)
    {
        return new StringSchema(schema.enums(enums));
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