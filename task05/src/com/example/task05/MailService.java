package com.example.task05;

import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MailService<T> implements Consumer {

    private Map<String, List<T>> mailBox = new TreeMap<String, List<T>>() {
        @Override
        public List<T> get(Object key) {
            if (super.get(key) == null) {
                super.put((String) key, new ArrayList<>());
            }

            return super.get(key);
        }
    };

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    public MailService() {

    }

    @Override
    public void accept(Object o) {
        AbstractMessage message = (AbstractMessage) o;
        mailBox.putIfAbsent(message.getTo(), new ArrayList<>());
        mailBox.computeIfAbsent(message.getTo(), k -> new ArrayList<>());
        mailBox.get(message.getTo()).add((T) message.getContent());
    }
}
