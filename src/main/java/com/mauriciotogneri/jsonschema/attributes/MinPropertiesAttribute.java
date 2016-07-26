package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueNumber;
import com.mauriciotogneri.jsonschema.support.PositiveNumber;

public class MinPropertiesAttribute implements Attribute
{
    private final PositiveNumber value;

    public MinPropertiesAttribute(PositiveNumber value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("minProperties", new JsonValueNumber(value));
    }
}