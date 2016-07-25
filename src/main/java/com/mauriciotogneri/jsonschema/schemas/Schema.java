package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.attributes.Attribute;
import com.mauriciotogneri.jsonschema.attributes.Attributes;
import com.mauriciotogneri.jsonschema.attributes.Description;
import com.mauriciotogneri.jsonschema.attributes.Enums;
import com.mauriciotogneri.jsonschema.attributes.ExclusiveMaximum;
import com.mauriciotogneri.jsonschema.attributes.ExclusiveMinimum;
import com.mauriciotogneri.jsonschema.attributes.Format;
import com.mauriciotogneri.jsonschema.attributes.Id;
import com.mauriciotogneri.jsonschema.attributes.MaxItems;
import com.mauriciotogneri.jsonschema.attributes.MaxLength;
import com.mauriciotogneri.jsonschema.attributes.MaxProperties;
import com.mauriciotogneri.jsonschema.attributes.Maximum;
import com.mauriciotogneri.jsonschema.attributes.MinIProperties;
import com.mauriciotogneri.jsonschema.attributes.MinItems;
import com.mauriciotogneri.jsonschema.attributes.MinLength;
import com.mauriciotogneri.jsonschema.attributes.Minimum;
import com.mauriciotogneri.jsonschema.attributes.MultipleOf;
import com.mauriciotogneri.jsonschema.attributes.Pattern;
import com.mauriciotogneri.jsonschema.attributes.SchemaVersion;
import com.mauriciotogneri.jsonschema.attributes.Title;
import com.mauriciotogneri.jsonschema.attributes.UniqueItems;
import com.mauriciotogneri.jsonschema.definitions.Definition;
import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.json.JsonObject;
import com.mauriciotogneri.jsonschema.json.JsonValue;
import com.mauriciotogneri.jsonschema.support.PositiveNumber;
import com.mauriciotogneri.jsonschema.support.Regex;
import com.mauriciotogneri.jsonschema.support.Uri;
import com.mauriciotogneri.jsonschema.types.FormatType;

public class Schema implements AbstractSchema
{
    private final Definitions definitions;
    private final Attributes attributes;

    protected Schema(Definitions definitions, Attributes attributes)
    {
        this.definitions = definitions;
        this.attributes = attributes;
    }

    public Schema id(String id)
    {
        return new Schema(definitions, attributes.add(new Id(new Uri(id))));
    }

    public Schema root()
    {
        return new Schema(definitions, attributes.add(new SchemaVersion()));
    }

    public Schema definition(Definition definition)
    {
        return new Schema(definitions.add(definition), attributes);
    }

    public Schema title(String title)
    {
        return new Schema(definitions, attributes.add(new Title(title)));
    }

    public Schema description(String description)
    {
        return new Schema(definitions, attributes.add(new Description(description)));
    }

    public Schema minLength(long minLength)
    {
        return new Schema(definitions, attributes.add(new MinLength(new PositiveNumber(minLength))));
    }

    public Schema maxLength(long maxLength)
    {
        return new Schema(definitions, attributes.add(new MaxLength(new PositiveNumber(maxLength))));
    }

    public Schema pattern(String pattern)
    {
        return new Schema(definitions, attributes.add(new Pattern(new Regex(pattern))));
    }

    public Schema format(FormatType format)
    {
        return new Schema(definitions, attributes.add(new Format(format)));
    }

    public Schema enums(Enums enums)
    {
        return new Schema(definitions, attributes.add(enums));
    }

    public Schema multipleOf(long value)
    {
        return new Schema(definitions, attributes.add(new MultipleOf(new PositiveNumber(value))));
    }

    public Schema multipleOf(double value)
    {
        return new Schema(definitions, attributes.add(new MultipleOf(new PositiveNumber(value))));
    }

    public Schema minimum(long value)
    {
        return new Schema(definitions, attributes.add(new Minimum<>(value)));
    }

    public Schema minimum(double value)
    {
        return new Schema(definitions, attributes.add(new Minimum<>(value)));
    }

    public Schema maximum(long value)
    {
        return new Schema(definitions, attributes.add(new Maximum<>(value)));
    }

    public Schema maximum(double value)
    {
        return new Schema(definitions, attributes.add(new Maximum<>(value)));
    }

    public Schema exclusiveMinimum(boolean value)
    {
        return new Schema(definitions, attributes.add(new ExclusiveMinimum(value)));
    }

    public Schema exclusiveMaximum(boolean value)
    {
        return new Schema(definitions, attributes.add(new ExclusiveMaximum(value)));
    }

    public Schema minItems(long minItems)
    {
        return new Schema(definitions, attributes.add(new MinItems(new PositiveNumber(minItems))));
    }

    public Schema maxItems(long maxItems)
    {
        return new Schema(definitions, attributes.add(new MaxItems(new PositiveNumber(maxItems))));
    }

    public Schema uniqueItems(boolean value)
    {
        return new Schema(definitions, attributes.add(new UniqueItems(value)));
    }

    public Schema minIProperties(long minIProperties)
    {
        return new Schema(definitions, attributes.add(new MinIProperties(new PositiveNumber(minIProperties))));
    }

    public Schema maxProperties(long maxProperties)
    {
        return new Schema(definitions, attributes.add(new MaxProperties(new PositiveNumber(maxProperties))));
    }

    @Override
    public Schema schema()
    {
        return this;
    }

    @Override
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