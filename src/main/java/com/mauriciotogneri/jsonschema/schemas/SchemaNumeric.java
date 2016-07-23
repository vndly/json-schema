package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.definitions.PositiveDouble;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

public class SchemaNumeric extends Schema
{
    private final PrimitiveType type;
    private final PositiveDouble multipleOf;
    private final Double minimum;
    private final Double maximum;
    private final Boolean exclusiveMinimum;
    private final Boolean exclusiveMaximum;

    // TODO: cannot set exclusiveMinimum without setting minimum
    // TODO: cannot set exclusiveMaximum without setting maximum
    // TODO: minimum cannot be bigger than maximum

    public SchemaNumeric(PrimitiveType type, PositiveDouble multipleOf, Double minimum, Double maximum, Boolean exclusiveMinimum, Boolean exclusiveMaximum)
    {
        this.type = type;
        this.multipleOf = multipleOf;
        this.minimum = minimum;
        this.maximum = maximum;
        this.exclusiveMinimum = exclusiveMinimum;
        this.exclusiveMaximum = exclusiveMaximum;
    }
}