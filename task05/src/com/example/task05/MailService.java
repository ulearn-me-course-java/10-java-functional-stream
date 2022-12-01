package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<IMessage> {
    private Map<String, List<T>> mailBox;

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    public MailService() {
        mailBox = new HashMap<String, List<T>>(){
            @Override
            public List<T> get(Object obj){
                return super.getOrDefault(obj, Collections.<T>emptyList());
            }
        };
    }

    @Override
    public void accept(IMessage message) {
        List<T> list = mailBox.computeIfAbsent(message.getTo(), k -> new ArrayList<>());
        list.add((T)message.getContent());
    }
}
