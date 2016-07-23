package com.mauriciotogneri.jsonschema.properties;

import com.mauriciotogneri.jsonschema.definitions.Regex;
import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueString;

public class Pattern implements Property
{
    private final Regex value;

    public Pattern(Regex value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("pattern", new JsonValueString(value.value()));
    }
}