package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.structures.ImmutableMap;

import java.util.Iterator;

public class Attributes implements Iterable<Attribute>
{
    private final ImmutableMap<Class<?>, Attribute> attributes;

    private Attributes(ImmutableMap<Class<?>, Attribute> attributes)
    {
        this.attributes = attributes;
    }

    public Attributes()
    {
        this.attributes = new ImmutableMap<>();
    }

    public Attributes add(Attribute attribute)
    {
        return new Attributes(attributes.put(attribute.getClass(), attribute));
    }

    public boolean isEmpty()
    {
        return attributes.isEmpty();
    }

    @Override
    public Iterator<Attribute> iterator()
    {
        return attributes.iterator();
    }
}