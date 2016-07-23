package com.mauriciotogneri.jsonschema.properties;

import com.mauriciotogneri.jsonschema.structures.ImmutableMap;

import java.util.Iterator;

public class Properties implements Iterable<Property>
{
    private final ImmutableMap<Class<?>, Property> properties;

    private Properties(ImmutableMap<Class<?>, Property> properties)
    {
        this.properties = properties;
    }

    public Properties()
    {
        this.properties = new ImmutableMap<>();
    }

    public Properties add(Property property)
    {
        return new Properties(properties.put(property.getClass(), property));
    }

    @Override
    public Iterator<Property> iterator()
    {
        return properties.iterator();
    }
}