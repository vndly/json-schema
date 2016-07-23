package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.attributes.Attributes;
import com.mauriciotogneri.jsonschema.attributes.Description;
import com.mauriciotogneri.jsonschema.attributes.SchemaVersion;
import com.mauriciotogneri.jsonschema.attributes.Title;
import com.mauriciotogneri.jsonschema.attributes.Type;
import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class SchemaArray extends Schema
{
    //    private final PrimitiveType type;
    //    private final ImmutableList<Schema> items;
    //    private final PositiveNumber minItems;
    //    private final PositiveNumber maxItems;
    //    private final Boolean uniqueItems;

    // TODO: minItems cannot be bigger than maxItems

    private SchemaArray(Definitions definitions, Attributes attributes)
    {
        super(definitions, attributes);
    }

    public SchemaArray()
    {
        super(new Definitions(), new Attributes().add(new Type(PrimitiveType.ARRAY)));
    }

    public SchemaArray root()
    {
        return new SchemaArray(definitions, attributes.add(new SchemaVersion()));
    }

    public SchemaArray definition(String name, Schema schema)
    {
        return new SchemaArray(definitions.add(name, schema), attributes);
    }

    public SchemaArray title(String title)
    {
        return new SchemaArray(definitions, attributes.add(new Title(title)));
    }

    public SchemaArray description(String description)
    {
        return new SchemaArray(definitions, attributes.add(new Description(description)));
    }
}