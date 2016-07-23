package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueString;

public class Description implements Attribute
{
    private final String value;

    public Description(String value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("description", new JsonValueString(value));
    }
}