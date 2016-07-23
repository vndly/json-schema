package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValueString;

public class SchemaVersion implements Attribute
{
    public SchemaVersion()
    {
    }

    @Override
    public JsonField json()
    {
        return new JsonField("$schema", new JsonValueString("http://json-schema.org/schema#"));
    }
}