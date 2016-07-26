package com.mauriciotogneri.jsonschema.definitions;

import com.mauriciotogneri.jsonschema.schemas.Schema;
import com.mauriciotogneri.jsonschema.structures.ImmutableMap;
import com.mauriciotogneri.jsonschema.support.ClassDef;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Definitions implements Iterable<Definition>
{
    private final ImmutableMap<String, Definition> schemas;

    private Definitions(ImmutableMap<String, Definition> schemas)
    {
        this.schemas = schemas;
    }

    public Definitions(ClassDef rootClassDef)
    {
        Map<String, Definition> map = new LinkedHashMap<>();

        Set<ClassDef> classes = new HashSet<>();
        rootClassDef.classes(classes);

        for (ClassDef classDef : classes)
        {
            Definition definition = new Definition(classDef.name(), new Schema(classDef, false));

            map.put(definition.name(), definition);
        }

        this.schemas = new ImmutableMap<>(map);
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