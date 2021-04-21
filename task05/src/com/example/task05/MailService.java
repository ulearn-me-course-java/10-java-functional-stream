package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Message> {

    private final Map<String, List<T>> mailBox = new HashMap<String, List<T>>() {
        @Override
        public  List<T> get(Object key) {
            return super.get(key) != null ?
                    super.get(key) : Collections.emptyList();
        }
    };

    @Override
    public void accept(Message message) {
        if (!(mailBox.containsKey(message.getTo())))
            mailBox.put(message.getTo(), new ArrayList<>());
        mailBox.get(message.getTo()).add((T) message.getContent());
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }
}
