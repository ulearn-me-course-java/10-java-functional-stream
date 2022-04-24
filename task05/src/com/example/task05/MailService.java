package com.example.task05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<MailContent<T>> {
    private final Map<String, List<T>> mailBox;
    
    public MailService() {
        mailBox = new HashMap<String, List<T>>() {
            @Override
            public List<T> get(Object key) {
                return super.getOrDefault(key, Collections.emptyList());
            }
        };
    }
    
    @Override
    public void accept(MailContent<T> content) {
        mailBox.computeIfAbsent(content.getTo(), a -> new ArrayList<>()).add(content.getContent());
    }
    
    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }
}
