package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueNumber;
import com.mauriciotogneri.jsonschema.support.NumberWrapper;

public class Maximum<N extends Number> implements Attribute
{
    private final NumberWrapper value;

    public Maximum(N value)
    {
        this.value = new NumberWrapper(value);
    }

    @Override
    public JsonField json()
    {
        return new JsonField("maximum", new JsonValueNumber(value));
    }
}