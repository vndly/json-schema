package com.mauriciotogneri.jsonschema.support;

import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.Map;

public class Annotations
{
    private final Map<Class<?>, Annotation> annotations;

    public Annotations(Annotation[] annotationList)
    {
        this.annotations = new LinkedHashMap<>();

        for (Annotation annotation : annotationList)
        {
            annotations.put(annotation.annotationType(), annotation);
        }
    }

    public <A extends Annotation> boolean has(Class<A> annotationClass)
    {
        return annotations.containsKey(annotationClass);
    }

    @SuppressWarnings("unchecked")
    public <A extends Annotation> A annotation(Class<A> annotationClass)
    {
        if (has(annotationClass))
        {
            return (A) annotations.get(annotationClass);
        }

        throw new RuntimeException(String.format("Annotation '%s' not found", annotationClass.toString()));
    }
}