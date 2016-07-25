package com.mauriciotogneri.jsonschema.test;

import com.mauriciotogneri.jsonschema.attributes.Enums;
import com.mauriciotogneri.jsonschema.definitions.Definition;
import com.mauriciotogneri.jsonschema.schemas.AnySchema;
import com.mauriciotogneri.jsonschema.schemas.ArraySchema;
import com.mauriciotogneri.jsonschema.schemas.BooleanSchema;
import com.mauriciotogneri.jsonschema.schemas.IntegerSchema;
import com.mauriciotogneri.jsonschema.schemas.NumberSchema;
import com.mauriciotogneri.jsonschema.schemas.ObjectSchema;
import com.mauriciotogneri.jsonschema.schemas.RootSchema;
import com.mauriciotogneri.jsonschema.schemas.StringSchema;
import com.mauriciotogneri.jsonschema.types.FormatType;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSample
{
    @Test
    public void testString() throws Exception
    {
        RootSchema root = new RootSchema(
                new StringSchema()
                        .title("Super string title")
                        .description("Amazing string description")
                        .minLength(1)
                        .maxLength(10)
                        .pattern("*")
                        .format(FormatType.DATE_TIME)
                        .enums(new Enums().withString("A").withBoolean(true).withNumber(123)));

        assertEquals(root.toString(), "{\"type\":\"string\",\"title\":\"Super string title\",\"description\":\"Amazing string description\",\"minLength\":1,\"maxLength\":10,\"pattern\":\"*\",\"format\":\"date-time\",\"enums\":[\"A\",true,123.0],\"$schema\":\"http://json-schema.org/schema#\"}");
    }

    @Test
    public void testBoolean() throws Exception
    {
        RootSchema root = new RootSchema(
                new BooleanSchema()
                        .title("Super boolean title")
                        .description("Amazing boolean description"));

        assertEquals(root.toString(), "{\"type\":\"boolean\",\"title\":\"Super boolean title\",\"description\":\"Amazing boolean description\",\"$schema\":\"http://json-schema.org/schema#\"}");
    }

    @Test
    public void tesInteger() throws Exception
    {
        RootSchema root = new RootSchema(
                new IntegerSchema()
                        .title("Super integer title")
                        .description("Amazing integer description")
                        .multipleOf(2)
                        .minimum(0)
                        .maximum(100)
                        .exclusiveMinimum(true)
                        .exclusiveMaximum(false));

        assertEquals(root.toString(), "{\"type\":\"integer\",\"title\":\"Super integer title\",\"description\":\"Amazing integer description\",\"multipleOf\":2,\"minimum\":0,\"maximum\":100,\"exclusiveMinimum\":true,\"exclusiveMaximum\":false,\"$schema\":\"http://json-schema.org/schema#\"}");
    }

    @Test
    public void tesNumber() throws Exception
    {
        RootSchema root = new RootSchema(
                new NumberSchema()
                        .title("Super number title")
                        .description("Amazing number description")
                        .multipleOf(2.5)
                        .minimum(0.1)
                        .maximum(100.0)
                        .exclusiveMinimum(false)
                        .exclusiveMaximum(true));

        assertEquals(root.toString(), "{\"type\":\"number\",\"title\":\"Super number title\",\"description\":\"Amazing number description\",\"multipleOf\":2.5,\"minimum\":0.1,\"maximum\":100.0,\"exclusiveMinimum\":false,\"exclusiveMaximum\":true,\"$schema\":\"http://json-schema.org/schema#\"}");
    }

    @Test
    public void testObject() throws Exception
    {
        RootSchema root = new RootSchema(
                new ObjectSchema()
                        .title("Super object title")
                        .description("Amazing object description")
                        .definition(new Definition("user_id", new StringSchema().pattern("[0-9]+"))));

        assertEquals(root.toString(), "{\"definitions\":{\"user_id\":{\"type\":\"string\",\"pattern\":\"[0-9]+\"}},\"type\":\"object\",\"title\":\"Super object title\",\"description\":\"Amazing object description\",\"$schema\":\"http://json-schema.org/schema#\"}");
    }

    @Test
    public void testArray() throws Exception
    {
        RootSchema root = new RootSchema(
                new ArraySchema()
                        .title("Super array title")
                        .description("Amazing array description"));

        assertEquals(root.toString(), "{\"type\":\"array\",\"title\":\"Super array title\",\"description\":\"Amazing array description\",\"$schema\":\"http://json-schema.org/schema#\"}");
    }

    @Test
    public void testAny() throws Exception
    {
        RootSchema root = new RootSchema(
                new AnySchema());

        assertEquals(root.toString(), "{\"$schema\":\"http://json-schema.org/schema#\"}");
    }
}