package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<IService<T>> {
    private Map<String, List<T>> box = new MyHashMap<>();

    @Override
    public void accept(IService<T> tiService) {
        if (!box.containsKey(tiService.getTo()))
            box.put(tiService.getTo(), new ArrayList<>());
        if (box.get(tiService.getTo()) != null)
            box.get(tiService.getTo()).add(tiService.getContent());
    }

    public Map<String, List<T>> getMailBox() {
        return box;
    }
}

class MyHashMap<T> extends HashMap<String, List<T>> {
    public List<T> get(Object key) {
        List<T> val = super.get(key);
        return val == null ? new ArrayList<>() : val;
    }
}
