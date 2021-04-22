package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Message<T>> {

    private final Map<String, List<T>> map = new HashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key) {
            return super.get(key) != null
                    ? super.get(key)
                    : Collections.emptyList();
        }
    };

    @Override
    public void accept(Message<T> message) {
        String to = message.getTo();

        if (!map.containsKey(to)) {
            map.put(to, new ArrayList<>());
        }

        map.get(to).add(message.getContent());
    }

    public Map<String, List<T>> getMailBox() {
        return map;
    }
}
