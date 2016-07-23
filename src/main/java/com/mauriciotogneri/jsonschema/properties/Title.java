package com.mauriciotogneri.jsonschema.properties;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueString;

public class Title implements Property
{
    private final String value;

    public Title(String value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("title", new JsonValueString(value));
    }
}