package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueString;
import com.mauriciotogneri.jsonschema.support.Uri;

public class Id implements Attribute
{
    private final Uri value;

    public Id(Uri value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("id", new JsonValueString(value.value()));
    }
}