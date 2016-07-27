package com.mauriciotogneri.jsonschema.attributes;

import com.mauriciotogneri.jsonschema.annotations.Description;
import com.mauriciotogneri.jsonschema.annotations.Enum;
import com.mauriciotogneri.jsonschema.annotations.ExclusiveMaximum;
import com.mauriciotogneri.jsonschema.annotations.ExclusiveMinimum;
import com.mauriciotogneri.jsonschema.annotations.Format;
import com.mauriciotogneri.jsonschema.annotations.Id;
import com.mauriciotogneri.jsonschema.annotations.Items;
import com.mauriciotogneri.jsonschema.annotations.MaxItems;
import com.mauriciotogneri.jsonschema.annotations.MaxLength;
import com.mauriciotogneri.jsonschema.annotations.MaxProperties;
import com.mauriciotogneri.jsonschema.annotations.Maximum;
import com.mauriciotogneri.jsonschema.annotations.MinItems;
import com.mauriciotogneri.jsonschema.annotations.MinLength;
import com.mauriciotogneri.jsonschema.annotations.MinProperties;
import com.mauriciotogneri.jsonschema.annotations.Minimum;
import com.mauriciotogneri.jsonschema.annotations.MultipleOf;
import com.mauriciotogneri.jsonschema.annotations.Pattern;
import com.mauriciotogneri.jsonschema.annotations.Reference;
import com.mauriciotogneri.jsonschema.annotations.Required;
import com.mauriciotogneri.jsonschema.annotations.Title;
import com.mauriciotogneri.jsonschema.annotations.Type;
import com.mauriciotogneri.jsonschema.annotations.UniqueItems;
import com.mauriciotogneri.jsonschema.schemas.Schema;
import com.mauriciotogneri.jsonschema.structures.ImmutableMap;
import com.mauriciotogneri.jsonschema.support.Annotations;
import com.mauriciotogneri.jsonschema.support.ClassDef;
import com.mauriciotogneri.jsonschema.support.FieldDef;
import com.mauriciotogneri.jsonschema.support.PositiveNumber;
import com.mauriciotogneri.jsonschema.support.Property;
import com.mauriciotogneri.jsonschema.support.Regex;
import com.mauriciotogneri.jsonschema.support.Uri;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

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

            if (annotations.has(Enum.class))
            {
                attributes.add(new EnumAttribute().withClass(annotations.annotation(Enum.class).value()));
            }

            if (annotations.has(Type.class))
            {
                attributes.add(new TypeAttribute(annotations.annotation(Type.class).value()));
            }

            if (annotations.has(MinLength.class))
            {
                attributes.add(new MinLengthAttribute(new PositiveNumber(annotations.annotation(MinLength.class).value())));
            }

            if (annotations.has(MaxLength.class))
            {
                attributes.add(new MaxLengthAttribute(new PositiveNumber(annotations.annotation(MaxLength.class).value())));
            }

            if (annotations.has(ExclusiveMinimum.class))
            {
                attributes.add(new ExclusiveMinimumAttribute(annotations.annotation(ExclusiveMinimum.class).value()));
            }

            if (annotations.has(ExclusiveMaximum.class))
            {
                attributes.add(new ExclusiveMaximumAttribute(annotations.annotation(ExclusiveMaximum.class).value()));
            }

            if (annotations.has(Format.class))
            {
                attributes.add(new FormatAttribute(annotations.annotation(Format.class).value()));
            }

            // TODO: is it really needed?
            if (annotations.has(Items.class))
            {
                List<Schema> schemas = new ArrayList<>();

                for (Class clazz : annotations.annotation(Items.class).value())
                {
                    schemas.add(new Schema(clazz));
                }

                attributes.add(new ItemsAttribute(schemas));
            }

            if (annotations.has(Minimum.class))
            {
                attributes.add(new MinimumAttribute(annotations.annotation(Minimum.class).value()));
            }

            if (annotations.has(Maximum.class))
            {
                attributes.add(new MaximumAttribute(annotations.annotation(Maximum.class).value()));
            }

            if (annotations.has(MinItems.class))
            {
                attributes.add(new MinItemsAttribute(new PositiveNumber(annotations.annotation(MinItems.class).value())));
            }

            if (annotations.has(MaxItems.class))
            {
                attributes.add(new MaxItemsAttribute(new PositiveNumber(annotations.annotation(MaxItems.class).value())));
            }

            if (annotations.has(MinProperties.class))
            {
                attributes.add(new MinPropertiesAttribute(new PositiveNumber(annotations.annotation(MinProperties.class).value())));
            }

            if (annotations.has(MaxProperties.class))
            {
                attributes.add(new MaxPropertiesAttribute(new PositiveNumber(annotations.annotation(MaxProperties.class).value())));
            }

            if (annotations.has(MultipleOf.class))
            {
                attributes.add(new MultipleOfAttribute(new PositiveNumber(annotations.annotation(MultipleOf.class).value())));
            }

            if (annotations.has(Pattern.class))
            {
                attributes.add(new PatternAttribute(new Regex(annotations.annotation(Pattern.class).value())));
            }

            if (annotations.has(Reference.class))
            {
                attributes.add(new ReferenceAttribute(annotations.annotation(Reference.class).value()));
            }

            if (annotations.has(Required.class))
            {
                attributes.add(new RequiredAttribute(annotations.annotation(Required.class).value()));
            }

            if (annotations.has(UniqueItems.class))
            {
                attributes.add(new UniqueItemsAttribute(annotations.annotation(UniqueItems.class).value()));
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
                attributes.add(ReferenceAttribute.fromDefinitions(classDef.name()));
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