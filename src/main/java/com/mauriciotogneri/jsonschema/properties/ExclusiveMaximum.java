package com.mauriciotogneri.jsonschema.properties;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueBoolean;

public class ExclusiveMaximum implements Property
{
    private final Boolean value;

    public ExclusiveMaximum(Boolean value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("exclusiveMinimum", new JsonValueBoolean(value));
    }
}