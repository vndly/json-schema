package com.mauriciotogneri.jsonschema.annotations;

import com.mauriciotogneri.jsonschema.types.FormatType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Format
{
    FormatType value();
}