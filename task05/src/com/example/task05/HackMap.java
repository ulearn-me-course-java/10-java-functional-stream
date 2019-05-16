package com.example.task05;


import java.util.*;

public class HackMap<T> extends HashMap<String, List<T>> {

    @Override
    public List<T> get(Object key) {
        List<T> value = super.get(key);
        return value == null ? new ArrayList<>(): value;
    }
}
