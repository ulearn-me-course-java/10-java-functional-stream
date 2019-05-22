package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class HashMapp<T> extends HashMap<String, List<T>> {
    public List<T> get(Object key){
        List<T> value = super.get(key);
        if (value == null)
            return new ArrayList<>();
        return value;
    }
}
