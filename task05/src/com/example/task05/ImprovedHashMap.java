package com.example.task05;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ImprovedHashMap<K, V> extends HashMap<K, List<V>> {

    @Override
    public List<V> get(Object key){
        return getOrDefault(key, Collections.emptyList());
    }
}
