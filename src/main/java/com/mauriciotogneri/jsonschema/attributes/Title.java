package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueString;

public class Title implements Attribute
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