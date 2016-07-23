package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.definitions.Definition;
import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.json.JsonObject;
import com.mauriciotogneri.jsonschema.json.JsonValue;
import com.mauriciotogneri.jsonschema.properties.Properties;
import com.mauriciotogneri.jsonschema.properties.Property;

public class Schema
{
    // TODO: implement id
    // TODO: implement default

    // TODO: create annotations to help apps to build schemas

    protected final Definitions definitions;
    protected final Properties properties;

    protected Schema(Definitions definitions, Properties properties)
    {
        this.definitions = definitions;
        this.properties = properties;
    }

    public JsonValue json()
    {
        JsonObject json = new JsonObject();

        json = json.add("$schema", "http://json-schema.org/schema#");

        if (!definitions.isEmpty())
        {
            json = json.add("definitions", jsonDefinitions());
        }

        if (!properties.isEmpty())
        {
            json = json.add("properties", jsonProperties());
        }

        return json;
    }

    @Override
    public String toString()
    {
        return json().toString();
    }

    private JsonObject jsonProperties()
    {
        JsonObject json = new JsonObject();

        for (Property property : properties)
        {
            json = json.add(property.json());
        }

        return json;
    }

    private JsonObject jsonDefinitions()
    {
        JsonObject json = new JsonObject();

        for (Definition definition : definitions)
        {
            json = json.add(definition.json());
        }

        return json;
    }
}