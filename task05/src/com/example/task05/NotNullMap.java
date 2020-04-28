package com.example.task05;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class NotNullMap<T> extends HashMap<String, List<T>> {

    @Override
    public List<T> get(Object key) {
        List<T> list = super.get(key);
        return list == null ? Collections.<T>emptyList() : list;
    }
}
