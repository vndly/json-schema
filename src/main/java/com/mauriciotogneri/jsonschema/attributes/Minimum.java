package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueNumber;
import com.mauriciotogneri.jsonschema.support.NumberWrapper;

public class Minimum<N extends Number> implements Attribute
{
    private final NumberWrapper value;

    public Minimum(N value)
    {
        this.value = new NumberWrapper(value);
    }

    @Override
    public JsonField json()
    {
        return new JsonField("minimum", new JsonValueNumber(value));
    }
}