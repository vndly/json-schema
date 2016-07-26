package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonPrimitive;
import com.mauriciotogneri.jsonschema.types.FormatType;

public class FormatAttribute implements Attribute
{
    private final FormatType value;

    public FormatAttribute(FormatType value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("format", new JsonPrimitive(value.toString()));
    }
}