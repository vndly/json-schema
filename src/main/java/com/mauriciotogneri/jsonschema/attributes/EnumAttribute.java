package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonArray;
import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonValue;
import com.mauriciotogneri.jsonschema.json.JsonValueBoolean;
import com.mauriciotogneri.jsonschema.json.JsonValueNumber;
import com.mauriciotogneri.jsonschema.json.JsonValueString;
import com.mauriciotogneri.jsonschema.structures.ImmutableList;

public class EnumAttribute implements Attribute
{
    private final ImmutableList<JsonValue> values;

    // TODO: allow null
    // TODO: check that elements are unique
    // TODO: check that size >= 1

    private EnumAttribute(ImmutableList<JsonValue> values)
    {
        this.values = values;
    }

    public EnumAttribute()
    {
        this.values = new ImmutableList<>();
    }

    public EnumAttribute withString(String value)
    {
        return new EnumAttribute(values.add(new JsonValueString(value)));
    }

    public EnumAttribute withInteger(long value)
    {
        return new EnumAttribute(values.add(new JsonValueNumber(value)));
    }

    public EnumAttribute withNumber(double value)
    {
        return new EnumAttribute(values.add(new JsonValueNumber(value)));
    }

    public EnumAttribute withBoolean(boolean value)
    {
        return new EnumAttribute(values.add(new JsonValueBoolean(value)));
    }

    @Override
    public JsonField json()
    {
        return new JsonField("enums", new JsonArray(values)); // TODO
    }
}