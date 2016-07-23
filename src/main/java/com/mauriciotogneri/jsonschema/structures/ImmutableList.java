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

    public int size()
    {
        return list.size();
    }

    public E get(int position)
    {
        return list.get(position);
    }

    public boolean contains(E element)
    {
        return list.contains(element);
    }

    @Override
    public Iterator<E> iterator()
    {
        return list.iterator();
    }
}