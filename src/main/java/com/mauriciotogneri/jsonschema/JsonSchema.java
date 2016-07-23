package com.mauriciotogneri.jsonschema;

import com.mauriciotogneri.jsonschema.types.PrimitiveType;

// https://spacetelescope.github.io/understanding-json-schema/reference/combining.html
public class JsonSchema
{
    private final String id;
    private final String schema;
    private final String description;
    private final Object definitions;
    private final PrimitiveType type;
    private final Object properties;
    private final Object dependencies;
    private final Object defaultValue;

    public JsonSchema(String id, String schema, String description, Object definitions, PrimitiveType type, Object properties, Object dependencies, Object defaultValue)
    {
        this.id = id;
        this.schema = schema;
        this.description = description;
        this.definitions = definitions;
        this.type = type;
        this.properties = properties;
        this.dependencies = dependencies;
        this.defaultValue = defaultValue;
    }
}