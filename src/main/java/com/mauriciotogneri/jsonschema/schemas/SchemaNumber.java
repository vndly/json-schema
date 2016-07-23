package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.attributes.Attributes;
import com.mauriciotogneri.jsonschema.attributes.Description;
import com.mauriciotogneri.jsonschema.attributes.ExclusiveMaximum;
import com.mauriciotogneri.jsonschema.attributes.ExclusiveMinimum;
import com.mauriciotogneri.jsonschema.attributes.Maximum;
import com.mauriciotogneri.jsonschema.attributes.Minimum;
import com.mauriciotogneri.jsonschema.attributes.MultipleOf;
import com.mauriciotogneri.jsonschema.attributes.SchemaVersion;
import com.mauriciotogneri.jsonschema.attributes.Title;
import com.mauriciotogneri.jsonschema.attributes.Type;
import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.support.PositiveNumber;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class SchemaNumber extends Schema
{
    // TODO: cannot set exclusiveMinimum without setting minimum
    // TODO: cannot set exclusiveMaximum without setting maximum
    // TODO: minimum cannot be bigger than maximum

    private SchemaNumber(Definitions definitions, Attributes attributes)
    {
        super(definitions, attributes);
    }

    public SchemaNumber()
    {
        super(new Definitions(), new Attributes().add(new Type(PrimitiveType.NUMBER)));
    }

    public SchemaNumber root()
    {
        return new SchemaNumber(definitions, attributes.add(new SchemaVersion()));
    }

    public SchemaNumber definition(String name, Schema schema)
    {
        return new SchemaNumber(definitions.add(name, schema), attributes);
    }

    public SchemaNumber title(String title)
    {
        return new SchemaNumber(definitions, attributes.add(new Title(title)));
    }

    public SchemaNumber description(String description)
    {
        return new SchemaNumber(definitions, attributes.add(new Description(description)));
    }

    public SchemaNumber multipleOf(double value)
    {
        return new SchemaNumber(definitions, attributes.add(new MultipleOf(new PositiveNumber(value))));
    }

    public SchemaNumber minimum(double value)
    {
        return new SchemaNumber(definitions, attributes.add(new Minimum<>(value)));
    }

    public SchemaNumber maximum(double value)
    {
        return new SchemaNumber(definitions, attributes.add(new Maximum<>(value)));
    }

    public SchemaNumber exclusiveMinimum(boolean value)
    {
        return new SchemaNumber(definitions, attributes.add(new ExclusiveMinimum(value)));
    }

    public SchemaNumber exclusiveMaximum(boolean value)
    {
        return new SchemaNumber(definitions, attributes.add(new ExclusiveMaximum(value)));
    }
}