package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonArray;
import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.schemas.Schema;

import java.util.Arrays;
import java.util.List;

public class ItemsAttribute implements Attribute
{
    private final List<Schema> schemas;

    public ItemsAttribute(Schema... schemas)
    {
        this(Arrays.asList(schemas));
    }

    public ItemsAttribute(List<Schema> schemas)
    {
        if (schemas.isEmpty())
        {
            throw new IllegalArgumentException("List of schemas cannot be empty");
        }

        this.schemas = schemas;
    }

    @Override
    public JsonField json()
    {
        if (schemas.size() == 1)
        {
            return new JsonField("items", schemas.get(0).json());
        }
        else
        {
            JsonArray itemsJson = new JsonArray();

            for (Schema schema : schemas)
            {
                itemsJson.add(schema.json());
            }

            return new JsonField("items", itemsJson);
        }
    }
}