package com.mauriciotogneri.jsonschema.structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImmutableList<E> implements Iterable<E>
{
    private final List<E> list;

    public ImmutableList(List<E> list)
    {
        this.list = list;
    }

    public ImmutableList()
    {
        this(new ArrayList<>());
    }

    public ImmutableList<E> add(E newElement)
    {
        List<E> newList = new ArrayList<>();
        newList.addAll(list);
        newList.add(newElement);

        return new ImmutableList<>(newList);
    }

    @Override
    public Iterator<E> iterator()
    {
        return list.iterator();
    }
}