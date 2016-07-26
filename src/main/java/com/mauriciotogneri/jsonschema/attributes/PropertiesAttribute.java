package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.json.JsonObject;
import com.mauriciotogneri.jsonschema.support.Property;

public class PropertiesAttribute implements Attribute
{
    private final Property[] properties;

    public PropertiesAttribute(Property... properties)
    {
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