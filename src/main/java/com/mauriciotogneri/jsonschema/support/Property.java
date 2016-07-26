package com.mauriciotogneri.jsonschema.support;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.schemas.Schema;

public class Property
{
    private final String name;
    private final Schema schema;

    public Property(FieldDef fieldDef)
    {
        this.name = fieldDef.name();
        this.schema = new Schema(fieldDef);
    }

    public JsonField json()
    {
        return new JsonField(name, schema.json());
    }
}