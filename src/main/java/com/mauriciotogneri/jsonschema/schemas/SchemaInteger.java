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

public class SchemaInteger extends Schema
{
    // TODO: cannot set exclusiveMinimum without setting minimum
    // TODO: cannot set exclusiveMaximum without setting maximum
    // TODO: minimum cannot be bigger than maximum

    private SchemaInteger(Definitions definitions, Attributes attributes)
    {
        super(definitions, attributes);
    }

    public SchemaInteger()
    {
        super(new Definitions(), new Attributes().add(new Type(PrimitiveType.INTEGER)));
    }

    public SchemaInteger root()
    {
        return new SchemaInteger(definitions, attributes.add(new SchemaVersion()));
    }

    public SchemaInteger definition(String name, Schema schema)
    {
        return new SchemaInteger(definitions.add(name, schema), attributes);
    }

    public SchemaInteger title(String title)
    {
        return new SchemaInteger(definitions, attributes.add(new Title(title)));
    }

    public SchemaInteger description(String description)
    {
        return new SchemaInteger(definitions, attributes.add(new Description(description)));
    }

    public SchemaInteger multipleOf(long value)
    {
        return new SchemaInteger(definitions, attributes.add(new MultipleOf(new PositiveNumber(value))));
    }

    public SchemaInteger minimum(long value)
    {
        return new SchemaInteger(definitions, attributes.add(new Minimum<>(value)));
    }

    public SchemaInteger maximum(long value)
    {
        return new SchemaInteger(definitions, attributes.add(new Maximum<>(value)));
    }

    public SchemaInteger exclusiveMinimum(boolean value)
    {
        return new SchemaInteger(definitions, attributes.add(new ExclusiveMinimum(value)));
    }

    public SchemaInteger exclusiveMaximum(boolean value)
    {
        return new SchemaInteger(definitions, attributes.add(new ExclusiveMaximum(value)));
    }
}