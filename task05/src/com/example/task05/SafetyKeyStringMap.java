package com.example.task05;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SafetyKeyStringMap<V> extends TreeMap<String,List<V>> {
    @Override
    public List<V> get(Object key){
        if(super.get(key)==null){
            super.put((String) key,new ArrayList<>());
        }

        return super.get(key);

    }
}
