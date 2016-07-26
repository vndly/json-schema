package com.mauriciotogneri.jsonschema.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.mauriciotogneri.jsonschema.annotations.Description;
import com.mauriciotogneri.jsonschema.annotations.MaxLength;
import com.mauriciotogneri.jsonschema.annotations.MinLength;
import com.mauriciotogneri.jsonschema.annotations.Title;
import com.mauriciotogneri.jsonschema.json.JsonElement;
import com.mauriciotogneri.jsonschema.schemas.Schema;

import org.junit.Test;

public class TestAnnotation
{
    @Test
    public void test() throws Exception
    {
        Schema schema = new Schema(Person.class).schemaVersion();
        print(schema.json());
    }

    @Title("Identifies a person")
    @Description("It can be a physical person or an imaginary person")
    public static class Person
    {
        @Description("The first name of the person")
        public String firstName;

        public String lastName;

        @MinLength(0)
        @MaxLength(120)
        public int age;

        public double weight;

        @Title("True if the person is married")
        public boolean married;

        public Address address;
    }

    public static class Address
    {
        public String street;

        public String number;

        public String city;

        public int postalCode;
    }

    private void print(JsonElement json)
    {
        JsonParser parser = new JsonParser();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        System.out.println(gson.toJson(parser.parse(json.toString())));
    }
}