package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.json.JsonObject;
import com.mauriciotogneri.jsonschema.properties.Properties;
import com.mauriciotogneri.jsonschema.properties.Property;

public class Schema
{
    // TODO: implement id
    // TODO: implement default

    // TODO: create annotations to help apps to build schemas

    protected final Properties properties;

    protected Schema(Properties properties)
    {
        this.properties = properties;
    }

    @Override
    public String toString()
    {
        JsonObject json = new JsonObject();

        for (Property property : properties)
        {
            json = json.add(property.json());
        }

        return json.toString();
    }
}