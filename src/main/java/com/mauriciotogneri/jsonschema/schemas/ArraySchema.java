package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.attributes.Attributes;
import com.mauriciotogneri.jsonschema.attributes.TypeAttribute;
import com.mauriciotogneri.jsonschema.definitions.Definition;
import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.json.JsonElement;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class ArraySchema implements AbstractSchema
{
    //    private final PrimitiveType type;
    //    private final ImmutableList<Schema> items;
    //    private final PositiveNumber minItems;
    //    private final PositiveNumber maxItems;
    //    private final Boolean uniqueItems;

    // TODO: minItems cannot be bigger than maxItems

    private final Schema schema;

    private ArraySchema(Schema schema)
    {
        this.schema = schema;
    }

    public ArraySchema()
    {
        this(new Schema(new Definitions(), new Attributes().add(new TypeAttribute(PrimitiveType.ARRAY))));
    }

    public ArraySchema definition(Definition definition)
    {
        return new ArraySchema(schema.definition(definition));
    }

    public ArraySchema title(String title)
    {
        return new ArraySchema(schema.title(title));
    }

    public ArraySchema description(String description)
    {
        return new ArraySchema(schema.description(description));
    }

    @Override
    public Schema schema()
    {
        return schema;
    }

    @Override
    public JsonElement json()
    {
        return schema.json();
    }

    @Override
    public String toString()
    {
        return schema.toString();
    }
}