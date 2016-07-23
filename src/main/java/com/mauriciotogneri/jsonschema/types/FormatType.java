package com.mauriciotogneri.jsonschema.types;

public enum FormatType
{
    DATE_TIME,
    EMAIL,
    HOSTNAME,
    IPv4,
    IPv6,
    URI;

    @Override
    public String toString()
    {
        return super.toString().toLowerCase().replace("_", "-");
    }
}