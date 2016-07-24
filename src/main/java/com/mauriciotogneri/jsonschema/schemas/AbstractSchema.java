package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.json.JsonValue;

public interface AbstractSchema
{
    Schema schema();

    JsonValue json();
}