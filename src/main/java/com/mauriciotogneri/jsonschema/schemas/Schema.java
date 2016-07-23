package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.attributes.Attribute;
import com.mauriciotogneri.jsonschema.attributes.Attributes;
import com.mauriciotogneri.jsonschema.definitions.Definition;
import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.json.JsonObject;
import com.mauriciotogneri.jsonschema.json.JsonValue;

public class Schema
{
    // TODO: implement id
    // TODO: implement default

    // TODO: create annotations to help apps to build schemas

    protected final Definitions definitions;
    protected final Attributes attributes;

    protected Schema(Definitions definitions, Attributes attributes)
    {
        this.definitions = definitions;
        this.attributes = attributes;
    }

    public JsonValue json()
    {
        JsonObject json = new JsonObject();

        if (!definitions.isEmpty())
        {
            json = json.add("definitions", jsonDefinitions());
        }

        for (Attribute attribute : attributes)
        {
            json = json.add(attribute.json());
        }

        return json;
    }

    @Override
    public String toString()
    {
        return json().toString();
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