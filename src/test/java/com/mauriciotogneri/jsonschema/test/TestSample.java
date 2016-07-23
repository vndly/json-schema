package com.mauriciotogneri.jsonschema.test;

import com.mauriciotogneri.jsonschema.attributes.Enums;
import com.mauriciotogneri.jsonschema.schemas.SchemaArray;
import com.mauriciotogneri.jsonschema.schemas.SchemaBoolean;
import com.mauriciotogneri.jsonschema.schemas.SchemaInteger;
import com.mauriciotogneri.jsonschema.schemas.SchemaNumber;
import com.mauriciotogneri.jsonschema.schemas.SchemaObject;
import com.mauriciotogneri.jsonschema.schemas.SchemaString;
import com.mauriciotogneri.jsonschema.types.FormatType;

import org.junit.Test;

public class TestSample
{
    @Test
    public void testString() throws Exception
    {
        SchemaString schemaString = new SchemaString()
                .root()
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
                .root()
                .title("Super boolean title")
                .description("Amazing boolean description");

        System.out.println(schemaBoolean);
    }

    @Test
    public void tesInteger() throws Exception
    {
        SchemaInteger schemaInteger = new SchemaInteger()
                .root()
                .title("Super integer title")
                .description("Amazing integer description")
                .multipleOf(2)
                .minimum(0)
                .maximum(100)
                .exclusiveMinimum(true)
                .exclusiveMaximum(false);

        System.out.println(schemaInteger);
    }

    @Test
    public void tesNumber() throws Exception
    {
        SchemaNumber schemaNumber = new SchemaNumber()
                .root()
                .title("Super number title")
                .description("Amazing number description")
                .multipleOf(2.5)
                .minimum(0.1)
                .maximum(100.0)
                .exclusiveMinimum(false)
                .exclusiveMaximum(true);

        System.out.println(schemaNumber);
    }

    @Test
    public void testObject() throws Exception
    {
        SchemaObject schemaObject = new SchemaObject()
                .root()
                .title("Super object title")
                .description("Amazing object description")
                .definition("user_id", new SchemaString().pattern("[0-9]+"));

        System.out.println(schemaObject);
    }

    @Test
    public void testArray() throws Exception
    {
        SchemaArray schemaArray = new SchemaArray()
                .root()
                .title("Super array title")
                .description("Amazing array description");

        System.out.println(schemaArray);
    }
}