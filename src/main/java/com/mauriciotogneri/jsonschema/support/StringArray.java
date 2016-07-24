package com.mauriciotogneri.jsonschema.support;

import com.mauriciotogneri.jsonschema.structures.ImmutableList;

public class StringArray
{
    private final ImmutableList<String> list;

    public StringArray(ImmutableList<String> value)
    {
        if (value.size() < 1)
        {
            throw new RuntimeException("String array cannot be empty");
        }

        this.list = value;
    }

    public StringArray add(String element)
    {
        if (list.contains(element))
        {
            throw new RuntimeException(String.format("Element '%s' already exist in string array", element));
        }

        return new StringArray(list.add(element));
    }
}