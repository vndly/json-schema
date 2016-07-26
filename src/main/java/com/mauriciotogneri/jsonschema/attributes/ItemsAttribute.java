package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.json.JsonArray;
import com.mauriciotogneri.jsonschema.json.JsonField;
import com.mauriciotogneri.jsonschema.schemas.Schema;

public class ItemsAttribute implements Attribute
{
    private final Schema[] schemas;

    public ItemsAttribute(Schema... schemas)
    {
        this.schemas = schemas;
    }

    @Override
    public JsonField json()
    {
        if (schemas.length == 1)
        {
            return new JsonField("items", schemas[0].json());
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