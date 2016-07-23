package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.properties.Description;
import com.mauriciotogneri.jsonschema.properties.Properties;
import com.mauriciotogneri.jsonschema.properties.Title;
import com.mauriciotogneri.jsonschema.properties.Type;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class SchemaBoolean extends Schema
{
    private SchemaBoolean(Properties properties)
    {
        super(properties);
    }

    public SchemaBoolean()
    {
        super(new Properties().add(new Type(PrimitiveType.BOOLEAN)));
    }

    public SchemaBoolean title(String title)
    {
        return new SchemaBoolean(properties.add(new Title(title)));
    }

    public SchemaBoolean description(String description)
    {
        return new SchemaBoolean(properties.add(new Description(description)));
    }
}