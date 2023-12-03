package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<IEntry<T>> {
    private Map<String, List<T>> mailBox = new HashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key) {
            List<T> list = super.get(key);
            return list != null ? list : new ArrayList<>();
        }
    };
    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(IEntry<T> message) {

        if(!mailBox.containsKey(message.getTo())) {
            mailBox.put(message.getTo(), new ArrayList<>());
        }
        mailBox.get(message.getTo()).add(message.getContent());
    }
}
