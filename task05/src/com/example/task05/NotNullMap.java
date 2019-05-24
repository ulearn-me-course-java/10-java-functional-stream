package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NotNullMap<K, V> extends HashMap<K, List<V>> {

    @Override
    public List<V> get(Object key) {

        List<V> value = super.get(key);

        if(value == null)
            return new ArrayList<>();

        return value;
    }
}
