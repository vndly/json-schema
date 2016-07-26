package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.json.JsonElement;

public interface AbstractSchema
{
    Schema schema();

    JsonElement json();
}