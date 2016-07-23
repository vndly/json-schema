package com.mauriciotogneri.jsonschema.structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ImmutableMap<K, V>
{
    private final Map<K, V> map;

    private ImmutableMap(Map<K, V> map)
    {
        this.map = map;
    }

    public ImmutableMap()
    {
        this(new HashMap<>());
    }

    public ImmutableMap<K, V> put(K key, V value)
    {
        Map<K, V> newMap = new HashMap<>();

        for (Entry<K, V> entry : map.entrySet())
        {
            newMap.put(entry.getKey(), entry.getValue());
        }

        newMap.put(key, value);

        return new ImmutableMap<>(newMap);
    }

    public ImmutableList<V> values()
    {
        return new ImmutableList<>(new ArrayList<>(map.values()));
    }

    public Iterator<V> iterator()
    {
        return values().iterator();
    }

    public Set<Entry<K, V>> entries()
    {
        return map.entrySet();
    }
}