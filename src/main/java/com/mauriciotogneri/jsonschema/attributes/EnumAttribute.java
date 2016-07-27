package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonArray;
import com.mauriciotogneri.jsonschema.json.JsonElement;
import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonPrimitive;
import com.mauriciotogneri.jsonschema.structures.ImmutableList;

public class EnumAttribute implements Attribute
{
    private final ImmutableList<JsonElement> values;

    // TODO: allow null
    // TODO: check that elements are unique
    // TODO: check that size >= 1

    private EnumAttribute(ImmutableList<JsonElement> values)
    {
        this.values = values;
    }

    public EnumAttribute()
    {
        this.values = new ImmutableList<>();
    }

    public EnumAttribute withClass(Class<? extends Enum> clazz)
    {
        ImmutableList<JsonElement> newValues = values;

        for (Object element : clazz.getEnumConstants())
        {
            newValues = newValues.add(new JsonPrimitive(element.toString()));
        }

        return new EnumAttribute(newValues);
    }

    public EnumAttribute withString(String value)
    {
        return new EnumAttribute(values.add(new JsonPrimitive(value)));
    }

    public EnumAttribute withInteger(long value)
    {
        return new EnumAttribute(values.add(new JsonPrimitive(value)));
    }

    public EnumAttribute withNumber(double value)
    {
        return new EnumAttribute(values.add(new JsonPrimitive(value)));
    }

    public EnumAttribute withBoolean(boolean value)
    {
        return new EnumAttribute(values.add(new JsonPrimitive(value)));
    }

    @Override
    public JsonField json()
    {
        return new JsonField("enums", new JsonArray(values)); // TODO
    }
}