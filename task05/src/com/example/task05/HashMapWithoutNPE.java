package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapWithoutNPE<T> extends HashMap<String, List<T>> {
    @Override
    public List<T> get(Object key) {
        List<T> v = super.get(key);
        return v == null ? new ArrayList<>() : v;
    }
}
