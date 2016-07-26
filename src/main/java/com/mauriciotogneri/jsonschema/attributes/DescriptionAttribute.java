package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueString;

public class DescriptionAttribute implements Attribute
{
    private final String value;

    public DescriptionAttribute(String value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("description", new JsonValueString(value));
    }
}