package com.mauriciotogneri.jsonschema.properties;

import com.mauriciotogneri.jsonschema.definitions.PositiveNumber;
import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueNumber;

public class MultipleOf implements Property
{
    private final PositiveNumber value;

    public MultipleOf(PositiveNumber value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("multipleOf", new JsonValueNumber(value.value()));
    }
}