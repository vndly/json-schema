package com.mauriciotogneri.jsonschema.schemas;

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

public class SchemaNumber extends Schema
{
    // TODO: cannot set exclusiveMinimum without setting minimum
    // TODO: cannot set exclusiveMaximum without setting maximum
    // TODO: minimum cannot be bigger than maximum

    private SchemaNumber(Properties properties)
    {
        super(properties);
    }

    public SchemaNumber()
    {
        super(new Properties().add(new Type(PrimitiveType.NUMBER)));
    }

    public SchemaNumber title(String title)
    {
        return new SchemaNumber(properties.add(new Title(title)));
    }

    public SchemaNumber description(String description)
    {
        return new SchemaNumber(properties.add(new Description(description)));
    }

    public SchemaNumber multipleOf(double value)
    {
        return new SchemaNumber(properties.add(new MultipleOf(new PositiveNumber(value))));
    }

    public SchemaNumber minimum(double value)
    {
        return new SchemaNumber(properties.add(new Minimum<>(value)));
    }

    public SchemaNumber maximum(double value)
    {
        return new SchemaNumber(properties.add(new Maximum<>(value)));
    }

    public SchemaNumber exclusiveMinimum(boolean value)
    {
        return new SchemaNumber(properties.add(new ExclusiveMinimum(value)));
    }

    public SchemaNumber exclusiveMaximum(boolean value)
    {
        return new SchemaNumber(properties.add(new ExclusiveMaximum(value)));
    }
}