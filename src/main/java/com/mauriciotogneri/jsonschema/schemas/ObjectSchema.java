package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.attributes.Attributes;
import com.mauriciotogneri.jsonschema.attributes.Type;
import com.mauriciotogneri.jsonschema.definitions.Definition;
import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.json.JsonValue;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class ObjectSchema implements AbstractSchema
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

    private final Schema schema;

    private ObjectSchema(Schema schema)
    {
        this.schema = schema;
    }

    public ObjectSchema()
    {
        this(new Schema(new Definitions(), new Attributes().add(new Type(PrimitiveType.OBJECT))));
    }

    public ObjectSchema definition(Definition definition)
    {
        return new ObjectSchema(schema.definition(definition));
    }

    public ObjectSchema title(String title)
    {
        return new ObjectSchema(schema.title(title));
    }

    public ObjectSchema description(String description)
    {
        return new ObjectSchema(schema.description(description));
    }

    @Override
    public Schema schema()
    {
        return schema;
    }

    @Override
    public JsonValue json()
    {
        return schema.json();
    }

    @Override
    public String toString()
    {
        return schema.toString();
    }
}