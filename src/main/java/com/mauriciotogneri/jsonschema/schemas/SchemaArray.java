package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.properties.Description;
import com.mauriciotogneri.jsonschema.properties.Properties;
import com.mauriciotogneri.jsonschema.properties.Title;
import com.mauriciotogneri.jsonschema.properties.Type;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class SchemaArray extends Schema
{
    //    private final PrimitiveType type;
    //    private final ImmutableList<Schema> items;
    //    private final PositiveNumber minItems;
    //    private final PositiveNumber maxItems;
    //    private final Boolean uniqueItems;

    // TODO: minItems cannot be bigger than maxItems

    private SchemaArray(Definitions definitions, Properties properties)
    {
        super(definitions, properties);
    }

    public SchemaArray()
    {
        super(new Definitions(), new Properties().add(new Type(PrimitiveType.ARRAY)));
    }

    public SchemaArray definition(String name, Schema schema)
    {
        return new SchemaArray(definitions.add(name, schema), properties);
    }

    public SchemaArray title(String title)
    {
        return new SchemaArray(definitions, properties.add(new Title(title)));
    }

    public SchemaArray description(String description)
    {
        return new SchemaArray(definitions, properties.add(new Description(description)));
    }
}