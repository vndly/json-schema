package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.properties.Description;
import com.mauriciotogneri.jsonschema.properties.Properties;
import com.mauriciotogneri.jsonschema.properties.Title;
import com.mauriciotogneri.jsonschema.properties.Type;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class SchemaObject extends Schema
{
    //    private final ImmutableMap<String, Schema> properties;
    //    private final ImmutableMap<Regex, Schema> patternProperties;
    //    private final Boolean additionalPropertiesFlag;
    //    private final Schema additionalPropertiesProperty;
    //    private final StringArray required;
    //    private final PositiveNumber minProperties;
    //    private final PositiveNumber maxProperties;
    //    private final Object dependencies;

    // TODO: additionalPropertiesFlag and additionalPropertiesProperty are mutually exclusive
    // TODO: minProperties cannot be bigger than maxProperties
    // TODO: dependencies

    private SchemaObject(Properties properties)
    {
        super(properties);
    }

    public SchemaObject()
    {
        super(new Properties().add(new Type(PrimitiveType.OBJECT)));
    }

    public SchemaObject title(String title)
    {
        return new SchemaObject(properties.add(new Title(title)));
    }

    public SchemaObject description(String description)
    {
        return new SchemaObject(properties.add(new Description(description)));
    }
}