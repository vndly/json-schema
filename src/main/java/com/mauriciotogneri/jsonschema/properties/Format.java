package com.mauriciotogneri.jsonschema.properties;

import com.mauriciotogneri.jsonschema.types.FormatType;
import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueString;

public class Format implements Property
{
    private final FormatType value;

    public Format(FormatType value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("format", new JsonValueString(value.toString()));
    }
}