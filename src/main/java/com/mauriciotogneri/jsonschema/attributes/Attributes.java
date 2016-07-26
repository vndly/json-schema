package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.annotations.Description;
import com.mauriciotogneri.jsonschema.annotations.Id;
import com.mauriciotogneri.jsonschema.annotations.MaxLength;
import com.mauriciotogneri.jsonschema.annotations.MinLength;
import com.mauriciotogneri.jsonschema.annotations.Title;
import com.mauriciotogneri.jsonschema.schemas.Schema;
import com.mauriciotogneri.jsonschema.structures.ImmutableMap;
import com.mauriciotogneri.jsonschema.support.Annotations;
import com.mauriciotogneri.jsonschema.support.ClassDef;
import com.mauriciotogneri.jsonschema.support.FieldDef;
import com.mauriciotogneri.jsonschema.support.PositiveNumber;
import com.mauriciotogneri.jsonschema.support.Property;
import com.mauriciotogneri.jsonschema.support.Uri;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class Attributes implements Iterable<Attribute>
{
    private final ImmutableMap<Class<?>, Attribute> attributes;

    private Attributes(ImmutableMap<Class<?>, Attribute> attributes)
    {
        this.attributes = attributes;
    }

    public Attributes(ClassDef classDef, Annotations annotations, boolean useReferences)
    {
        AttributeMap attributes = new AttributeMap();

        if (classDef.isPrimitive() || !useReferences)
        {
            attributes.add(new TypeAttribute(primitiveType(classDef)));

            if (annotations.has(Title.class))
            {
                attributes.add(new TitleAttribute(annotations.annotation(Title.class).value()));
            }

            if (annotations.has(Description.class))
            {
                attributes.add(new DescriptionAttribute(annotations.annotation(Description.class).value()));
            }

            if (annotations.has(Id.class))
            {
                attributes.add(new IdAttribute(new Uri(annotations.annotation(Id.class).value())));
            }

            if (annotations.has(MinLength.class))
            {
                attributes.add(new MinLengthAttribute(new PositiveNumber(annotations.annotation(MinLength.class).value())));
            }

            if (annotations.has(MaxLength.class))
            {
                attributes.add(new MaxLengthAttribute(new PositiveNumber(annotations.annotation(MaxLength.class).value())));
            }
        }

        if (classDef.isArray())
        {
            attributes.add(new ItemsAttribute(new Schema(classDef.componentType(), true)));
        }
        else if (classDef.isObject())
        {
            if (useReferences)
            {
                attributes.add(RefAttribute.fromDefinitions(classDef.name()));
            }
            else
            {
                attributes.add(new PropertiesAttribute(properties(classDef)));
            }
        }

        this.attributes = new ImmutableMap<>(attributes);
    }

    public Attributes()
    {
        this(new ImmutableMap<>());
    }

    public Attributes add(Attribute attribute)
    {
        return new Attributes(attributes.put(attribute.getClass(), attribute));
    }

    private Property[] properties(ClassDef classDef)
    {
        FieldDef[] fields = classDef.fields();
        Property[] properties = new Property[fields.length];

        for (int i = 0; i < fields.length; i++)
        {
            FieldDef fieldDef = fields[i];

            properties[i] = new Property(fieldDef.name(), new Schema(fieldDef));
        }

        return properties;
    }

    private PrimitiveType primitiveType(ClassDef classDef)
    {
        if (classDef.isString())
        {
            return PrimitiveType.STRING;
        }
        else if (classDef.isBoolean())
        {
            return PrimitiveType.BOOLEAN;
        }
        else if (classDef.isInteger())
        {
            return PrimitiveType.INTEGER;
        }
        else if (classDef.isNumber())
        {
            return PrimitiveType.NUMBER;
        }
        else if (classDef.isArray())
        {
            return PrimitiveType.ARRAY;
        }
        else
        {
            return PrimitiveType.OBJECT;
        }
    }

    @Override
    public Iterator<Attribute> iterator()
    {
        return attributes.iterator();
    }

    private static class AttributeMap extends LinkedHashMap<Class<?>, Attribute>
    {
        public void add(Attribute attribute)
        {
            put(attribute.getClass(), attribute);
        }
    }
}