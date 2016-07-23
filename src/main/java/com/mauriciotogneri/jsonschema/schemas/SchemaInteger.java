package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.definitions.PositiveDouble;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class SchemaInteger extends SchemaNumeric
{
    public SchemaInteger(PositiveDouble multipleOf, Double minimum, Double maximum, Boolean exclusiveMinimum, Boolean exclusiveMaximum)
    {
        super(PrimitiveType.INTEGER, multipleOf, minimum, maximum, exclusiveMinimum, exclusiveMaximum);
    }
}