package com.mauriciotogneri.jsonschema.schemas;

import com.mauriciotogneri.jsonschema.attributes.Attribute;
import com.mauriciotogneri.jsonschema.attributes.Attributes;
import com.mauriciotogneri.jsonschema.attributes.DescriptionAttribute;
import com.mauriciotogneri.jsonschema.attributes.EnumAttribute;
import com.mauriciotogneri.jsonschema.attributes.ExclusiveMaximumAttribute;
import com.mauriciotogneri.jsonschema.attributes.ExclusiveMinimumAttribute;
import com.mauriciotogneri.jsonschema.attributes.FormatAttribute;
import com.mauriciotogneri.jsonschema.attributes.IdAttribute;
import com.mauriciotogneri.jsonschema.attributes.ItemsAttribute;
import com.mauriciotogneri.jsonschema.attributes.MaxItemsAttribute;
import com.mauriciotogneri.jsonschema.attributes.MaxLengthAttribute;
import com.mauriciotogneri.jsonschema.attributes.MaxPropertiesAttribute;
import com.mauriciotogneri.jsonschema.attributes.MaximumAttribute;
import com.mauriciotogneri.jsonschema.attributes.MinItemsAttribute;
import com.mauriciotogneri.jsonschema.attributes.MinLengthAttribute;
import com.mauriciotogneri.jsonschema.attributes.MinPropertiesAttribute;
import com.mauriciotogneri.jsonschema.attributes.MinimumAttribute;
import com.mauriciotogneri.jsonschema.attributes.MultipleOfAttribute;
import com.mauriciotogneri.jsonschema.attributes.PatternAttribute;
import com.mauriciotogneri.jsonschema.attributes.PropertiesAttribute;
import com.mauriciotogneri.jsonschema.attributes.RefAttribute;
import com.mauriciotogneri.jsonschema.attributes.RequiredAttribute;
import com.mauriciotogneri.jsonschema.attributes.SchemaAttribute;
import com.mauriciotogneri.jsonschema.attributes.TitleAttribute;
import com.mauriciotogneri.jsonschema.attributes.UniqueItemsAttribute;
import com.mauriciotogneri.jsonschema.definitions.Definition;
import com.mauriciotogneri.jsonschema.definitions.Definitions;
import com.mauriciotogneri.jsonschema.json.JsonElement;
import com.mauriciotogneri.jsonschema.json.JsonObject;
import com.mauriciotogneri.jsonschema.support.Annotations;
import com.mauriciotogneri.jsonschema.support.ClassDef;
import com.mauriciotogneri.jsonschema.support.FieldDef;
import com.mauriciotogneri.jsonschema.support.PositiveNumber;
import com.mauriciotogneri.jsonschema.support.Property;
import com.mauriciotogneri.jsonschema.support.Regex;
import com.mauriciotogneri.jsonschema.support.Uri;
import com.mauriciotogneri.jsonschema.types.FormatType;

import java.util.List;

// https://spacetelescope.github.io/understanding-json-schema
// https://json-schema-validator.herokuapp.com/syntax.jsp
public class Schema implements AbstractSchema
{
    private final Definitions definitions;
    private final Attributes attributes;

    protected Schema(Definitions definitions, Attributes attributes)
    {
        this.definitions = definitions;
        this.attributes = attributes;
    }

    private Schema(ClassDef classDef, Annotations annotations, boolean useReferences)
    {
        this(new Definitions(), new Attributes(classDef, annotations, useReferences));
    }

    public Schema(ClassDef classDef, boolean useReferences)
    {
        this(classDef, new Annotations(classDef.annotations()), useReferences);
    }

    public Schema(FieldDef fieldDef, boolean useReferences)
    {
        this(fieldDef.classDef(), new Annotations(fieldDef.annotations()), useReferences);
    }

    public Schema(Class<?> clazz)
    {
        ClassDef classDef = new ClassDef(clazz);
        Annotations annotations = new Annotations(classDef.annotations());

        this.definitions = new Definitions(classDef);
        this.attributes = new Attributes(classDef, annotations, true);
    }

    public Schema()
    {
        this(new Definitions(), new Attributes());
    }

    public Schema attribute(Attribute attribute)
    {
        return new Schema(definitions, attributes.add(attribute));
    }

    public Schema id(String id)
    {
        return new Schema(definitions, attributes.add(new IdAttribute(new Uri(id))));
    }

    public Schema schemaVersion()
    {
        return new Schema(definitions, attributes.add(new SchemaAttribute()));
    }

    public Schema definition(Definition definition)
    {
        return new Schema(definitions.add(definition), attributes);
    }

    public Schema title(String title)
    {
        return new Schema(definitions, attributes.add(new TitleAttribute(title)));
    }

    public Schema description(String description)
    {
        return new Schema(definitions, attributes.add(new DescriptionAttribute(description)));
    }

    public Schema ref(String ref)
    {
        return new Schema(definitions, attributes.add(new RefAttribute(ref)));
    }

    public Schema properties(Property... properties)
    {
        return new Schema(definitions, attributes.add(new PropertiesAttribute(properties)));
    }

    public Schema items(Schema... schemas)
    {
        return new Schema(definitions, attributes.add(new ItemsAttribute(schemas)));
    }

    public Schema minLength(long minLength)
    {
        return new Schema(definitions, attributes.add(new MinLengthAttribute(new PositiveNumber(minLength))));
    }

    public Schema maxLength(long maxLength)
    {
        return new Schema(definitions, attributes.add(new MaxLengthAttribute(new PositiveNumber(maxLength))));
    }

    public Schema pattern(String pattern)
    {
        return new Schema(definitions, attributes.add(new PatternAttribute(new Regex(pattern))));
    }

    public Schema format(FormatType format)
    {
        return new Schema(definitions, attributes.add(new FormatAttribute(format)));
    }

    public Schema enums(EnumAttribute enums)
    {
        return new Schema(definitions, attributes.add(enums));
    }

    public Schema multipleOf(long value)
    {
        return new Schema(definitions, attributes.add(new MultipleOfAttribute(new PositiveNumber(value))));
    }

    public Schema multipleOf(double value)
    {
        return new Schema(definitions, attributes.add(new MultipleOfAttribute(new PositiveNumber(value))));
    }

    public Schema minimum(long value)
    {
        return new Schema(definitions, attributes.add(new MinimumAttribute<>(value)));
    }

    public Schema minimum(double value)
    {
        return new Schema(definitions, attributes.add(new MinimumAttribute<>(value)));
    }

    public Schema maximum(long value)
    {
        return new Schema(definitions, attributes.add(new MaximumAttribute<>(value)));
    }

    public Schema maximum(double value)
    {
        return new Schema(definitions, attributes.add(new MaximumAttribute<>(value)));
    }

    public Schema exclusiveMinimum(boolean value)
    {
        return new Schema(definitions, attributes.add(new ExclusiveMinimumAttribute(value)));
    }

    public Schema exclusiveMaximum(boolean value)
    {
        return new Schema(definitions, attributes.add(new ExclusiveMaximumAttribute(value)));
    }

    public Schema minItems(long minItems)
    {
        return new Schema(definitions, attributes.add(new MinItemsAttribute(new PositiveNumber(minItems))));
    }

    public Schema maxItems(long maxItems)
    {
        return new Schema(definitions, attributes.add(new MaxItemsAttribute(new PositiveNumber(maxItems))));
    }

    public Schema uniqueItems(boolean value)
    {
        return new Schema(definitions, attributes.add(new UniqueItemsAttribute(value)));
    }

    public Schema minIProperties(long minIProperties)
    {
        return new Schema(definitions, attributes.add(new MinPropertiesAttribute(new PositiveNumber(minIProperties))));
    }

    public Schema maxProperties(long maxProperties)
    {
        return new Schema(definitions, attributes.add(new MaxPropertiesAttribute(new PositiveNumber(maxProperties))));
    }

    public Schema required(String... values)
    {
        return new Schema(definitions, attributes.add(new RequiredAttribute(values)));
    }

    public Schema required(List<String> values)
    {
        return new Schema(definitions, attributes.add(new RequiredAttribute(values)));
    }

    @Override
    public Schema schema()
    {
        return this;
    }

    @Override
    public JsonElement json()
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