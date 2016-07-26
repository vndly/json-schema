package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonPrimitive;

public class RefAttribute implements Attribute
{
    private final String ref;

    public RefAttribute(String ref)
    {
        this.ref = ref;
    }

    @Override
    public JsonField json()
    {
        return new JsonField("$ref", new JsonPrimitive(ref));
    }

    public static RefAttribute fromDefinitions(String ref)
    {
        return new RefAttribute(String.format("#/definitions/%s", ref));
    }
}