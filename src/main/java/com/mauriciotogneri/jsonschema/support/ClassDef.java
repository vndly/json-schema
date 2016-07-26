package com.mauriciotogneri.jsonschema.support;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class ClassDef
{
    private final Class<?> clazz;

    public ClassDef(Class<?> clazz)
    {
        this.clazz = clazz;
    }

    public String name()
    {
        return clazz.getSimpleName();
    }

    public Annotation[] annotations()
    {
        return clazz.getDeclaredAnnotations();
    }

    public ClassDef componentType()
    {
        if (clazz.isArray())
        {
            return new ClassDef(clazz.getComponentType());
        }
        else
        {
            ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();

            return new ClassDef((Class) parameterizedType.getActualTypeArguments()[0]);
        }
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

    public boolean isObject()
    {
        return !isString() &&
                !isBoolean() &&
                !isInteger() &&
                !isNumber() &&
                !isArray();
    }
}