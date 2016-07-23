package com.mauriciotogneri.jsonschema.properties;

import com.mauriciotogneri.jsonschema.definitions.PositiveInteger;
import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueNumber;

public class MinLength implements Property
{
    private final PositiveInteger value;

    public MinLength(PositiveInteger value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("minLength", new JsonValueNumber(value.value()));
    }
}