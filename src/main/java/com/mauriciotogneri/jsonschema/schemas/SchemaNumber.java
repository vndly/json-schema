package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.definitions.PositiveDouble;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class SchemaNumber extends SchemaNumeric
{
    public SchemaNumber(PositiveDouble multipleOf, Double minimum, Double maximum, Boolean exclusiveMinimum, Boolean exclusiveMaximum)
    {
        super(PrimitiveType.NUMBER, multipleOf, minimum, maximum, exclusiveMinimum, exclusiveMaximum);
    }
}