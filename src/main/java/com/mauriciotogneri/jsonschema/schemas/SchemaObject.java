package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.definitions.PositiveInteger;
import com.mauriciotogneri.jsonschema.definitions.Regex;
import com.mauriciotogneri.jsonschema.definitions.StringArray;
import com.mauriciotogneri.jsonschema.structures.ImmutableMap;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class SchemaObject extends Schema
{
    private final PrimitiveType type;
    private final ImmutableMap<String, Schema> properties;
    private final ImmutableMap<Regex, Schema> patternProperties;
    private final Boolean additionalPropertiesFlag;
    private final Schema additionalPropertiesProperty;
    private final StringArray required;
    private final PositiveInteger minProperties;
    private final PositiveInteger maxProperties;
    private final Object dependencies;

    // TODO: additionalPropertiesFlag and additionalPropertiesProperty are mutually exclusive
    // TODO: minProperties cannot be bigger than maxProperties
    // TODO: dependencies

    public SchemaObject(ImmutableMap<String, Schema> properties, ImmutableMap<Regex, Schema> patternProperties, Boolean additionalPropertiesFlag, Schema additionalPropertiesProperty, StringArray required, PositiveInteger minProperties, PositiveInteger maxProperties, Object dependencies)
    {
        this.type = PrimitiveType.OBJECT;
        this.properties = properties;
        this.patternProperties = patternProperties;
        this.additionalPropertiesFlag = additionalPropertiesFlag;
        this.additionalPropertiesProperty = additionalPropertiesProperty;
        this.required = required;
        this.minProperties = minProperties;
        this.maxProperties = maxProperties;
        this.dependencies = dependencies;
    }
}