package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonPrimitive;

public class ExclusiveMinimumAttribute implements Attribute
{
    private final Boolean value;

    public ExclusiveMinimumAttribute(Boolean value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("exclusiveMinimum", new JsonPrimitive(value));
    }
}