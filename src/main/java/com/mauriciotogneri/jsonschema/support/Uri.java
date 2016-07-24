package com.mauriciotogneri.jsonschema.support;

public class Uri
{
    private final String value;

    public Uri(String value)
    {
        // TODO: validate uri
        if (value.isEmpty())
        {
            throw new RuntimeException(String.format("Invalid URI: %s", value));
        }

        this.value = value;
    }

    public String value()
    {
        return value;
    }
}