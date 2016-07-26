package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueBoolean;

public class UniqueItemsAttribute implements Attribute
{
    private final Boolean value;

    public UniqueItemsAttribute(Boolean value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("uniqueItems", new JsonValueBoolean(value));
    }
}