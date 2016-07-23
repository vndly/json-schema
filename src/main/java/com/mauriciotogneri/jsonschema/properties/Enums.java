package com.mauriciotogneri.jsonschema.properties;

import com.mauriciotogneri.jsonschema.json.JsonArray;
import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValue;
import com.mauriciotogneri.jsonschema.json.JsonValueBoolean;
import com.mauriciotogneri.jsonschema.json.JsonValueNumber;
import com.mauriciotogneri.jsonschema.json.JsonValueString;
import com.mauriciotogneri.jsonschema.structures.ImmutableList;

public class Enums implements Property
{
    private final ImmutableList<JsonValue> values;

    // TODO: allow null
    // TODO: define objects and arrays
    // TODO: check that size >= 1

    private Enums(ImmutableList<JsonValue> values)
    {
        this.values = values;
    }

    public Enums()
    {
        this.values = new ImmutableList<>();
    }

    public Enums withString(String value)
    {
        return new Enums(values.add(new JsonValueString(value)));
    }

    public Enums withInteger(long value)
    {
        return new Enums(values.add(new JsonValueNumber(value)));
    }

    public Enums withNumber(double value)
    {
        return new Enums(values.add(new JsonValueNumber(value)));
    }

    public Enums withBoolean(boolean value)
    {
        return new Enums(values.add(new JsonValueBoolean(value)));
    }

    @Override
    public JsonField json()
    {
        return new JsonField("enums", new JsonArray(values)); // TODO
    }
}