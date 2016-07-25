package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonArray;
import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValue;
import com.mauriciotogneri.jsonschema.json.JsonValueBoolean;
import com.mauriciotogneri.jsonschema.json.JsonValueNumber;
import com.mauriciotogneri.jsonschema.json.JsonValueString;
import com.mauriciotogneri.jsonschema.structures.ImmutableList;

public class Enum implements Attribute
{
    private final ImmutableList<JsonValue> values;

    // TODO: allow null
    // TODO: check that elements are unique
    // TODO: check that size >= 1

    private Enum(ImmutableList<JsonValue> values)
    {
        this.values = values;
    }

    public Enum()
    {
        this.values = new ImmutableList<>();
    }

    public Enum withString(String value)
    {
        return new Enum(values.add(new JsonValueString(value)));
    }

    public Enum withInteger(long value)
    {
        return new Enum(values.add(new JsonValueNumber(value)));
    }

    public Enum withNumber(double value)
    {
        return new Enum(values.add(new JsonValueNumber(value)));
    }

    public Enum withBoolean(boolean value)
    {
        return new Enum(values.add(new JsonValueBoolean(value)));
    }

    @Override
    public JsonField json()
    {
        return new JsonField("enums", new JsonArray(values)); // TODO
    }
}