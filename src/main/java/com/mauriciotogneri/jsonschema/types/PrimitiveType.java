package com.mauriciotogneri.jsonschema.types;

public enum PrimitiveType
{
    BOOLEAN,
    STRING,
    INTEGER,
    NUMBER,
    OBJECT,
    ARRAY,
    NULL;

    @Override
    public String toString()
    {
        return super.toString().toLowerCase();
    }
}