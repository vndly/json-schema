package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.definitions.PositiveNumber;
import com.mauriciotogneri.jsonschema.definitions.Regex;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;
import com.mauriciotogneri.jsonschema.types.FormatType;
import com.mauriciotogneri.jsonschema.properties.Description;
import com.mauriciotogneri.jsonschema.properties.Enums;
import com.mauriciotogneri.jsonschema.properties.Format;
import com.mauriciotogneri.jsonschema.properties.MaxLength;
import com.mauriciotogneri.jsonschema.properties.MinLength;
import com.mauriciotogneri.jsonschema.properties.Pattern;
import com.mauriciotogneri.jsonschema.properties.Properties;
import com.mauriciotogneri.jsonschema.properties.Title;
import com.mauriciotogneri.jsonschema.properties.Type;

public class SchemaString extends Schema
{
    private SchemaString(Properties properties)
    {
        super(properties);
    }

    public SchemaString()
    {
        super(new Properties().add(new Type(PrimitiveType.STRING)));
    }

    public SchemaString title(String title)
    {
        return new SchemaString(properties.add(new Title(title)));
    }

    public SchemaString description(String description)
    {
        return new SchemaString(properties.add(new Description(description)));
    }

    public SchemaString minLength(long minLength)
    {
        return new SchemaString(properties.add(new MinLength(new PositiveNumber(minLength))));
    }

    public SchemaString maxLength(long maxLength)
    {
        return new SchemaString(properties.add(new MaxLength(new PositiveNumber(maxLength))));
    }

    public SchemaString pattern(String pattern)
    {
        return new SchemaString(properties.add(new Pattern(new Regex(pattern))));
    }

    public SchemaString format(FormatType format)
    {
        return new SchemaString(properties.add(new Format(format)));
    }

    public SchemaString enums(Enums enums)
    {
        return new SchemaString(properties.add(enums));
    }
}