package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.structures.ImmutableMap;
import com.mauriciotogneri.jsonschema.support.ClassDef;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Attributes implements Iterable<Attribute>
{
    private final ImmutableMap<Class<?>, Attribute> attributes;

    private Attributes(ImmutableMap<Class<?>, Attribute> attributes)
    {
        this.attributes = attributes;
    }

    public Attributes(ClassDef classDef)
    {
        Map<Class<?>, Attribute> attributes = new LinkedHashMap<>();

        if (classDef.isString())
        {
            attributes.put(Type.class, new Type(PrimitiveType.STRING));
        }
        else if (classDef.isBoolean())
        {
            attributes.put(Type.class, new Type(PrimitiveType.BOOLEAN));
        }
        else if (classDef.isInteger())
        {
            attributes.put(Type.class, new Type(PrimitiveType.INTEGER));
        }
        else if (classDef.isNumber())
        {
            attributes.put(Type.class, new Type(PrimitiveType.NUMBER));
        }
        else if (classDef.isArray())
        {
            attributes.put(Type.class, new Type(PrimitiveType.ARRAY));
        }
        else
        {
            attributes.put(Type.class, new Type(PrimitiveType.OBJECT));
        }

        this.attributes = new ImmutableMap<>(attributes);
    }

    public Attributes()
    {
        this(new ImmutableMap<>());
    }

    public Attributes add(Attribute attribute)
    {
        return new Attributes(attributes.put(attribute.getClass(), attribute));
    }

    @Override
    public Iterator<Attribute> iterator()
    {
        return attributes.iterator();
    }
}