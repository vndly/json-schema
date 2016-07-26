package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueNumber;

public class MaximumAttribute<N extends Number> implements Attribute
{
    private final Number value;

    public MaximumAttribute(N value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("maximum", new JsonValueNumber(value));
    }
}