package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<MailParts<T>> {
    private final HashMap<String, List<T>> mailBox = new HashMap<String, List<T>>() {
        @Override
        public  List<T> get(Object key) {
            List<T> value = super.get(key);
            if (value != null) return value;
            else return Collections.emptyList();
        }
    };

    @Override
    public void accept(MailParts<T> t) {
        if (mailBox.containsKey(t.getTo()))
            mailBox.get(t.getTo()).add(t.getContent());
        else
            mailBox.put(t.getTo(), new ArrayList<>(Collections.singletonList(t.getContent())));
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }
}