package com.mauriciotogneri.jsonschema.support;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldDef
{
    private final Field field;

    public FieldDef(Field field)
    {
        this.field = field;
    }

    public String name()
    {
        return field.getName();
    }

    public ClassDef classDef()
    {
        return new ClassDef(field.getType());
    }

    public boolean isStatic()
    {
        return Modifier.isStatic(field.getModifiers());
    }

    public Annotation[] annotations()
    {
        return field.getDeclaredAnnotations();
    }
}