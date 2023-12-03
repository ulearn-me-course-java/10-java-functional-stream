package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Sendable<T>> {
    private HashMap<String, List<T>> mailBox = new HashMap<String, List<T>>(){
        @Override
        public List<T> get(Object key) {
            return super.get(key) == null ? new ArrayList<>() : super.get(key);
        }
    };

    public void accept(Sendable<T> message) {
        if(!mailBox.containsKey(message.getTo())) {
            mailBox.put(message.getTo(), new ArrayList<>());
            mailBox.get(message.getTo()).add(message.getContent());
        }
        else
        {
            mailBox.get(message.getTo()).add(message.getContent());
        }
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }
}
