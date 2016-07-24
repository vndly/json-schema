package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.attributes.Attributes;
import com.mauriciotogneri.jsonschema.attributes.Description;
import com.mauriciotogneri.jsonschema.attributes.SchemaVersion;
import com.mauriciotogneri.jsonschema.attributes.Title;
import com.mauriciotogneri.jsonschema.definitions.Definitions;

public class SchemaAny extends Schema
{
    // TODO: can it have title and description?

    private SchemaAny(Definitions definitions, Attributes attributes)
    {
        super(definitions, attributes);
    }

    public SchemaAny()
    {
        super(new Definitions(), new Attributes());
    }

    public SchemaAny root()
    {
        return new SchemaAny(definitions, attributes.add(new SchemaVersion()));
    }

    public SchemaAny title(String title)
    {
        return new SchemaAny(definitions, attributes.add(new Title(title)));
    }

    public SchemaAny description(String description)
    {
        return new SchemaAny(definitions, attributes.add(new Description(description)));
    }
}