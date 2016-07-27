package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonPrimitive;

public class ReferenceAttribute implements Attribute
{
    private final String ref;

    public ReferenceAttribute(String ref)
    {
        this.ref = ref;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("$ref", new JsonPrimitive(ref));
    }

    public static ReferenceAttribute fromDefinitions(String ref)
    {
        return new ReferenceAttribute(String.format("#/definitions/%s", ref));
    }
}