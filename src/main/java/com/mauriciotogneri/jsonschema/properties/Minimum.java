package com.mauriciotogneri.jsonschema.properties;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueNumber;

public class Minimum<N extends Number> implements Property
{
    private final N value;

    public Minimum(N value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        // TODO: print int value if N is int
        return new JsonField("minimum", new JsonValueNumber(value.doubleValue()));
    }
}