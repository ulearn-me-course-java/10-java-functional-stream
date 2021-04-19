package com.example.task05;

import java.util.*;

public class MailMap<TItem> extends HashMap<String, List<TItem>> {
    @Override
    public List<TItem> get(Object key) {
        return getOrDefault(key, Collections.emptyList());
    }
}
