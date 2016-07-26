package com.mauriciotogneri.jsonschema.support;

import java.util.List;

public class ClassDef
{
    private final Class<?> clazz;

    public ClassDef(Class<?> clazz)
    {
        this.clazz = clazz;
    }

    public boolean isString()
    {
        return clazz.equals(String.class);
    }

    public boolean isBoolean()
    {
        return (clazz.equals(Boolean.class) ||
                clazz.equals(boolean.class));
    }

    public boolean isInteger()
    {
        return (clazz.equals(Integer.class) ||
                clazz.equals(Long.class) ||
                clazz.equals(int.class) ||
                clazz.equals(long.class) ||
                clazz.equals(short.class) ||
                clazz.equals(byte.class) ||
                clazz.equals(char.class));
    }

    public boolean isNumber()
    {
        return (clazz.equals(Float.class) ||
                clazz.equals(Double.class) ||
                clazz.equals(float.class) ||
                clazz.equals(double.class));
    }

    public boolean isArray()
    {
        return (clazz.isArray() ||
                List.class.isAssignableFrom(clazz));
    }
}