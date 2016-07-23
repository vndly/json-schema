package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueBoolean;

public class ExclusiveMinimum implements Attribute
{
    private final Boolean value;

    public ExclusiveMinimum(Boolean value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("exclusiveMinimum", new JsonValueBoolean(value));
    }
}