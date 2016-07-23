package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.attributes.Attributes;
import com.mauriciotogneri.jsonschema.attributes.Description;
import com.mauriciotogneri.jsonschema.attributes.Enums;
import com.mauriciotogneri.jsonschema.attributes.Format;
import com.mauriciotogneri.jsonschema.attributes.MaxLength;
import com.mauriciotogneri.jsonschema.attributes.MinLength;
import com.mauriciotogneri.jsonschema.attributes.Pattern;
import com.mauriciotogneri.jsonschema.attributes.SchemaVersion;
import com.mauriciotogneri.jsonschema.attributes.Title;
import com.mauriciotogneri.jsonschema.attributes.Type;
import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.support.PositiveNumber;
import com.mauriciotogneri.jsonschema.support.Regex;
import com.mauriciotogneri.jsonschema.types.FormatType;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class SchemaString extends Schema
{
    private SchemaString(Definitions definitions, Attributes attributes)
    {
        super(definitions, attributes);
    }

    public SchemaString()
    {
        super(new Definitions(), new Attributes().add(new Type(PrimitiveType.STRING)));
    }

    public SchemaString root()
    {
        return new SchemaString(definitions, attributes.add(new SchemaVersion()));
    }

    public SchemaString definition(String name, Schema schema)
    {
        return new SchemaString(definitions.add(name, schema), attributes);
    }

    public SchemaString title(String title)
    {
        return new SchemaString(definitions, attributes.add(new Title(title)));
    }

    public SchemaString description(String description)
    {
        return new SchemaString(definitions, attributes.add(new Description(description)));
    }

    public SchemaString minLength(long minLength)
    {
        return new SchemaString(definitions, attributes.add(new MinLength(new PositiveNumber(minLength))));
    }

    public SchemaString maxLength(long maxLength)
    {
        return new SchemaString(definitions, attributes.add(new MaxLength(new PositiveNumber(maxLength))));
    }

    public SchemaString pattern(String pattern)
    {
        return new SchemaString(definitions, attributes.add(new Pattern(new Regex(pattern))));
    }

    public SchemaString format(FormatType format)
    {
        return new SchemaString(definitions, attributes.add(new Format(format)));
    }

    public SchemaString enums(Enums enums)
    {
        return new SchemaString(definitions, attributes.add(enums));
    }
}