package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CrutchMap<K, V> extends HashMap<K, List<V>> {

    @Override
    public List<V> get(Object key) {
        List<V> value =  super.get(key);
        return value == null ? new ArrayList<>() : value;
    }
}
