package com.mauriciotogneri.jsonschema.support;

public class Regex
{
    private final String value;

    public Regex(String value)
    {
        // TODO: validate regex
        // http://www.ecma-international.org/publications/standards/Ecma-262.htm
        // https://spacetelescope.github.io/understanding-json-schema/reference/regular_expressions.html#regular-expressions
        if (value.isEmpty())
        {
            throw new RuntimeException(String.format("Invalid regex: %s", value));
        }

        this.value = value;
    }

    public String value()
    {
        return value;
    }
}