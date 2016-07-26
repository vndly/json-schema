package com.mauriciotogneri.jsonschema.definitions;

import com.mauriciotogneri.jsonschema.structures.ImmutableMap;
import com.mauriciotogneri.jsonschema.support.ClassDef;

import java.util.Iterator;

public class Definitions implements Iterable<Definition>
{
    private final ImmutableMap<String, Definition> schemas;

    private Definitions(ImmutableMap<String, Definition> schemas)
    {
        this.schemas = schemas;
    }

    public Definitions(ClassDef classDef)
    {
        this.schemas = new ImmutableMap<>();

        // TODO: fill the map
    }

    public Definitions()
    {
        this(new ImmutableMap<>());
    }

    public boolean isEmpty()
    {
        return schemas.isEmpty();
    }

    public Definitions add(Definition definition)
    {
        return new Definitions(schemas.put(definition.name(), definition));
    }

    @Override
    public Iterator<Definition> iterator()
    {
        return schemas.iterator();
    }
}