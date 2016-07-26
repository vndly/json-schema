package com.mauriciotogneri.jsonschema.support;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public FieldDef[] fields()
    {
        Field[] fields = clazz.getDeclaredFields();
        List<FieldDef> result = new ArrayList<>();

        for (Field field : fields)
        {
            FieldDef fieldDef = new FieldDef(field);

            if (!fieldDef.isStatic())
            {
                result.add(fieldDef);
            }
        }

        return result.toArray(new FieldDef[result.size()]);
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

    public void classes(Set<ClassDef> classes)
    {
        if (!classes.contains(this))
        {
            if (isObject())
            {
                classes.add(this);

                for (FieldDef fieldDef : fields())
                {
                    fieldDef.classDef().classes(classes);
                }
            }
            else if (isArray())
            {
                componentType().classes(classes);
            }
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

    public boolean isPrimitive()
    {
        return isString() ||
                isBoolean() ||
                isInteger() ||
                isNumber();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        else if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        ClassDef classDef = (ClassDef) o;

        return clazz.equals(classDef.clazz);
    }

    @Override
    public int hashCode()
    {
        return clazz.hashCode();
    }
}