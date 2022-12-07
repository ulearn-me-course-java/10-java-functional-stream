package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<MailItem<T>> {
    private final HashMap<String, List<T>> mailBox = new HashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key) {
            return super.get(key) == null ? Collections.emptyList() : super.get(key);
        }
    };

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(MailItem<T> item) {
        if (!mailBox.containsKey(item.getTo()))
            mailBox.put(item.getTo(), new ArrayList<>());
        mailBox.get(item.getTo()).add(item.getContent());
    }
}
