package com.mauriciotogneri.jsonschema.test;

import com.mauriciotogneri.jsonschema.annotations.Description;
import com.mauriciotogneri.jsonschema.annotations.MinLength;
import com.mauriciotogneri.jsonschema.annotations.Title;
import com.mauriciotogneri.jsonschema.schemas.Schema;

import org.junit.Test;

public class TestAnnotation
{
    @Test
    public void test() throws Exception
    {
        Schema schema = new Schema(Person.class).schemaVersion();
        System.out.println(schema.toString());
    }

    @Title("Identifies a person")
    @Description("It can be a physical person or an imaginary person")
    public static class Person
    {
        @Description("The first name of the person")
        public String firstName;

        public String lastName;

        @MinLength(0)
        public int age;

        public double weight;

        @Title("True if the person is married")
        public boolean married;
    }
}