package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueString;
import com.mauriciotogneri.jsonschema.support.Uri;

public class IdAttribute implements Attribute
{
    private final Uri value;

    public IdAttribute(Uri value)
    {
        this.value = value;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("id", new JsonValueString(value.value()));
    }
}