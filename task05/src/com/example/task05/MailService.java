package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Message<T>> {

    private final Map<String, List<T>> mailBox = new HashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key) {
            return mailBox.getOrDefault(key, Collections.emptyList());
        }
    };

    public Map<String, List<T>> getMailBox(){
        return this.mailBox;
    }

    @Override
    public void accept(Message<T> message) {
        if (this.mailBox.containsKey(message.getTo())) {
            List<T> list = this.mailBox.get(message.getTo());
            list.add(message.getContent());
        } else {
            List<T> content = new ArrayList<>(Collections.singletonList(message.getContent()));
            this.mailBox.put(message.getTo(), content);
        }
    }
}
