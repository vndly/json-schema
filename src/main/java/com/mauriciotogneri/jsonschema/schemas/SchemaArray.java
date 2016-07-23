package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.definitions.PositiveNumber;
import com.mauriciotogneri.jsonschema.structures.ImmutableList;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class SchemaArray extends Schema
{
    private final PrimitiveType type;
    private final ImmutableList<Schema> items;
    private final PositiveNumber minItems;
    private final PositiveNumber maxItems;
    private final Boolean uniqueItems;

    // TODO: minItems cannot be bigger than maxItems

    public SchemaArray(ImmutableList<Schema> items, PositiveNumber minItems, PositiveNumber maxItems, Boolean uniqueItems)
    {
        this.type = PrimitiveType.ARRAY;
        this.items = items;
        this.minItems = minItems;
        this.maxItems = maxItems;
        this.uniqueItems = uniqueItems;
    }
}