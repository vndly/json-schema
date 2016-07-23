package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.definitions.PositiveNumber;
import com.mauriciotogneri.jsonschema.properties.Description;
import com.mauriciotogneri.jsonschema.properties.ExclusiveMaximum;
import com.mauriciotogneri.jsonschema.properties.ExclusiveMinimum;
import com.mauriciotogneri.jsonschema.properties.Maximum;
import com.mauriciotogneri.jsonschema.properties.Minimum;
import com.mauriciotogneri.jsonschema.properties.MultipleOf;
import com.mauriciotogneri.jsonschema.properties.Properties;
import com.mauriciotogneri.jsonschema.properties.Title;
import com.mauriciotogneri.jsonschema.properties.Type;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class SchemaInteger extends Schema
{
    // TODO: cannot set exclusiveMinimum without setting minimum
    // TODO: cannot set exclusiveMaximum without setting maximum
    // TODO: minimum cannot be bigger than maximum

    private SchemaInteger(Definitions definitions, Properties properties)
    {
        super(definitions, properties);
    }

    public SchemaInteger()
    {
        super(new Definitions(), new Properties().add(new Type(PrimitiveType.INTEGER)));
    }

    public SchemaInteger definition(String name, Schema schema)
    {
        return new SchemaInteger(definitions.add(name, schema), properties);
    }

    public SchemaInteger title(String title)
    {
        return new SchemaInteger(definitions, properties.add(new Title(title)));
    }

    public SchemaInteger description(String description)
    {
        return new SchemaInteger(definitions, properties.add(new Description(description)));
    }

    public SchemaInteger multipleOf(long value)
    {
        return new SchemaInteger(definitions, properties.add(new MultipleOf(new PositiveNumber(value))));
    }

    public SchemaInteger minimum(long value)
    {
        return new SchemaInteger(definitions, properties.add(new Minimum<>(value)));
    }

    public SchemaInteger maximum(long value)
    {
        return new SchemaInteger(definitions, properties.add(new Maximum<>(value)));
    }

    public SchemaInteger exclusiveMinimum(boolean value)
    {
        return new SchemaInteger(definitions, properties.add(new ExclusiveMinimum(value)));
    }

    public SchemaInteger exclusiveMaximum(boolean value)
    {
        return new SchemaInteger(definitions, properties.add(new ExclusiveMaximum(value)));
    }
}