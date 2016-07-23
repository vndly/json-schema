package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.attributes.Attributes;
import com.mauriciotogneri.jsonschema.attributes.Description;
import com.mauriciotogneri.jsonschema.attributes.SchemaVersion;
import com.mauriciotogneri.jsonschema.attributes.Title;
import com.mauriciotogneri.jsonschema.attributes.Type;
import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class SchemaBoolean extends Schema
{
    private SchemaBoolean(Definitions definitions, Attributes attributes)
    {
        super(definitions, attributes);
    }

    public SchemaBoolean()
    {
        super(new Definitions(), new Attributes().add(new Type(PrimitiveType.BOOLEAN)));
    }

    public SchemaBoolean root()
    {
        return new SchemaBoolean(definitions, attributes.add(new SchemaVersion()));
    }

    public SchemaBoolean definition(String name, Schema schema)
    {
        return new SchemaBoolean(definitions.add(name, schema), attributes);
    }

    public SchemaBoolean title(String title)
    {
        return new SchemaBoolean(definitions, attributes.add(new Title(title)));
    }

    public SchemaBoolean description(String description)
    {
        return new SchemaBoolean(definitions, attributes.add(new Description(description)));
    }
}