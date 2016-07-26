package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueBoolean;

public class ExclusiveMaximumAttribute implements Attribute
{
    private final Boolean value;

    public ExclusiveMaximumAttribute(Boolean value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("exclusiveMaximum", new JsonValueBoolean(value));
    }
}