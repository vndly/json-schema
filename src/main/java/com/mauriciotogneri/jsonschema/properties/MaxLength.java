package com.mauriciotogneri.jsonschema.properties;

import com.mauriciotogneri.jsonschema.definitions.PositiveNumber;
import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueNumber;

public class MaxLength implements Property
{
    private final PositiveNumber value;

    public MaxLength(PositiveNumber value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("maxLength", new JsonValueNumber(value.value()));
    }
}