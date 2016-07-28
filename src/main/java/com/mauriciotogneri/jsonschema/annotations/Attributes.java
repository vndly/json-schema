package com.mauriciotogneri.jsonschema.annotations;

import com.mauriciotogneri.jsonschema.types.FormatType;
import com.mauriciotogneri.jsonschema.types.PrimitiveType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Attributes
{
    String[] description() default {};
    Class<? extends java.lang.Enum>[] enums() default {};
    boolean[] exclusiveMaximum() default {};
    boolean[] exclusiveMinimum() default {};
    FormatType[] format() default {};
    String[] id() default {};
    Class[] items() default {};
    double[] maximum() default {};
    int[] maxItems() default {};
    int[] maxLength() default {};
    int[] maxProperties() default {};
    double[] minimum() default {};
    int[] minItems() default {};
    int[] minLength() default {};
    int[] minProperties() default {};
    double[] multipleOf() default {};
    String[] pattern() default {};
    String[] reference() default {};
    String[] required() default {};
    String[] title() default {};
    PrimitiveType[] type() default {};
    boolean[] uniqueItems() default {};
}