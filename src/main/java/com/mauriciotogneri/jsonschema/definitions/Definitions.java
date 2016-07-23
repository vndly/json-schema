package com.mauriciotogneri.jsonschema.definitions;

import com.mauriciotogneri.jsonschema.schemas.Schema;
import com.mauriciotogneri.jsonschema.structures.ImmutableMap;

import java.util.Iterator;

public class Definitions implements Iterable<Definition>
{
    private final ImmutableMap<String, Definition> schemas;

    private Definitions(ImmutableMap<String, Definition> schemas)
    {
        this.schemas = schemas;
    }

    public Definitions()
    {
        this.schemas = new ImmutableMap<>();
    }

    public boolean isEmpty()
    {
        return schemas.isEmpty();
    }

    public Definitions add(String name, Schema schema)
    {
        return new Definitions(schemas.put(name, new Definition(name, schema)));
    }

    @Override
    public Iterator<Definition> iterator()
    {
        return schemas.iterator();
    }
}