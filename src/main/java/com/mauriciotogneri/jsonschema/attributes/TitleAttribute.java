package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonPrimitive;

public class TitleAttribute implements Attribute
{
    private final String value;

    public TitleAttribute(String value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("title", new JsonPrimitive(value));
    }
}