package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.properties.Description;
import com.mauriciotogneri.jsonschema.properties.Properties;
import com.mauriciotogneri.jsonschema.properties.Title;
import com.mauriciotogneri.jsonschema.properties.Type;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class SchemaBoolean extends Schema
{
    private SchemaBoolean(Definitions definitions, Properties properties)
    {
        super(definitions, properties);
    }

    public SchemaBoolean()
    {
        super(new Definitions(), new Properties().add(new Type(PrimitiveType.BOOLEAN)));
    }

    public SchemaBoolean definition(String name, Schema schema)
    {
        return new SchemaBoolean(definitions.add(name, schema), properties);
    }

    public SchemaBoolean title(String title)
    {
        return new SchemaBoolean(definitions, properties.add(new Title(title)));
    }

    public SchemaBoolean description(String description)
    {
        return new SchemaBoolean(definitions, properties.add(new Description(description)));
    }
}