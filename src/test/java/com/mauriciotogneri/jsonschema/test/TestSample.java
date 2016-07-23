package com.mauriciotogneri.jsonschema.test;

import com.mauriciotogneri.jsonschema.properties.Enums;
import com.mauriciotogneri.jsonschema.schemas.SchemaBoolean;
import com.mauriciotogneri.jsonschema.schemas.SchemaInteger;
import com.mauriciotogneri.jsonschema.schemas.SchemaString;
import com.mauriciotogneri.jsonschema.types.FormatType;

import org.junit.Test;

public class TestSample
{
    @Test
    public void testString() throws Exception
    {
        SchemaString schemaString = new SchemaString()
                .title("Super string title")
                .description("Amazing string description")
                .minLength(1)
                .maxLength(10)
                .pattern("*")
                .format(FormatType.DATE_TIME)
                .enums(new Enums().withString("A").withBoolean(true).withNumber(123));

        System.out.println(schemaString);
    }

    @Test
    public void testBoolean() throws Exception
    {
        SchemaBoolean schemaBoolean = new SchemaBoolean()
                .title("Super boolean title")
                .description("Amazing boolean description");

        System.out.println(schemaBoolean);
    }

    @Test
    public void tesInteger() throws Exception
    {
        SchemaInteger schemaInteger = new SchemaInteger()
                .title("Super integer title")
                .description("Amazing integer description")
                .multipleOf(2)
                .minimum(0)
                .maximum(100)
                .exclusiveMinimum(true)
                .exclusiveMaximum(false);

        System.out.println(schemaInteger);
    }
}