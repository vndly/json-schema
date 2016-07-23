package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.attributes.Attributes;
import com.mauriciotogneri.jsonschema.attributes.Description;
import com.mauriciotogneri.jsonschema.attributes.SchemaVersion;
import com.mauriciotogneri.jsonschema.attributes.Title;
import com.mauriciotogneri.jsonschema.attributes.Type;
import com.mauriciotogneri.jsonschema.definitions.Definitions;
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

    private SchemaObject(Definitions definitions, Attributes attributes)
    {
        super(definitions, attributes);
    }

    public SchemaObject()
    {
        super(new Definitions(), new Attributes().add(new Type(PrimitiveType.OBJECT)));
    }

    public SchemaObject root()
    {
        return new SchemaObject(definitions, attributes.add(new SchemaVersion()));
    }

    public SchemaObject definition(String name, Schema schema)
    {
        return new SchemaObject(definitions.add(name, schema), attributes);
    }

    public SchemaObject title(String title)
    {
        return new SchemaObject(definitions, attributes.add(new Title(title)));
    }

    public SchemaObject description(String description)
    {
        return new SchemaObject(definitions, attributes.add(new Description(description)));
    }
}