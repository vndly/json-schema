package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueString;
import com.mauriciotogneri.jsonschema.support.Regex;

public class PatternAttribute implements Attribute
{
    private final Regex value;

    public PatternAttribute(Regex value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("pattern", new JsonValueString(value.value()));
    }
}