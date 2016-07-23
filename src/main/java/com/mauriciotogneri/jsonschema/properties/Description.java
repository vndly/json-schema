package com.mauriciotogneri.jsonschema.properties;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueString;

public class Description implements Property
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