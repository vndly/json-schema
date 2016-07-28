package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonObject;
import com.mauriciotogneri.jsonschema.support.Property;

import java.util.Arrays;
import java.util.List;

public class PropertiesAttribute implements Attribute
{
    private final List<Property> properties;

    public PropertiesAttribute(Property... properties)
    {
        this(Arrays.asList(properties));
    }

    public PropertiesAttribute(List<Property> properties)
    {
        if (properties.isEmpty())
        {
            throw new IllegalArgumentException("List of properties cannot be empty");
        }

        this.properties = properties;
    }

    @Override
    public JsonField json()
    {
        JsonObject json = new JsonObject();

        for (Property property : properties)
        {
            json = json.add(property.json());
        }

        return new JsonField("properties", json);
    }
}