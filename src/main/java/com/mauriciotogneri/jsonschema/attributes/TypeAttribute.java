package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonPrimitive;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

import java.util.Arrays;
import java.util.List;

public class TypeAttribute implements Attribute
{
    private final List<PrimitiveType> types;

    public TypeAttribute(PrimitiveType... types)
    {
        this(Arrays.asList(types));
    }

    public TypeAttribute(List<PrimitiveType> types)
    {
        if (types.isEmpty())
        {
            throw new IllegalArgumentException("List of primitive types cannot be empty");
        }

        this.types = types;
    }

    @Override
    public JsonField json()
    {
        if (types.size() == 1)
        {
            return new JsonField("type", new JsonPrimitive(types.get(0).toString()));
        }
        else
        {
            // TODO
            return new JsonField("type", new JsonPrimitive(types.toString()));
        }
    }
}