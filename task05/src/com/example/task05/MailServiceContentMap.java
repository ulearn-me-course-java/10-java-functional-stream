package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MailServiceContentMap<T> extends HashMap<String, List<T>> {
    @Override
    public List<T> get(Object key) {
        List<T> value = super.get(key);
        return value != null ? value : new ArrayList<>() ;
    }
}
