package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Message> {

    private final HashMap<String, List<T>> mailBox = new HashMap<String, List<T>>() {
        @Override
        public  List<T> get(Object key) {
            List<T> value = super.get(key);
            if (value != null) return value;
            else return Collections.emptyList();
        }
    };

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Message message) {
        if (!mailBox.containsKey(message.getTo()))
            mailBox.put(message.getTo(), new ArrayList<>());
        (mailBox.get(message.getTo())).add((T) message.getContent());
    }

}

