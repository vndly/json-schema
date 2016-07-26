package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonPrimitive;

public class SchemaAttribute implements Attribute
{
    public SchemaAttribute()
    {
    }

    @Override
    public JsonField json()
    {
        return new JsonField("$schema", new JsonPrimitive("http://json-schema.org/schema#"));
    }
}