package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Message<T>> {

    private final Map<String, List<T>> mailBox = new HashMap<String, List<T>>(){
        @Override
        public List<T> get(Object key){
            List<T> list = super.get(key);
            return list != null ? list : Collections.emptyList();
        }
    };

    @Override
    public void accept(Message<T> message){
        String mesTo = message.getTo();
        if(!mailBox.containsKey(mesTo)) mailBox.put(mesTo, new ArrayList<>());
        mailBox.get(mesTo).add(message.getContent());
    }

    public Map<String, List<T>> getMailBox(){
        return mailBox;
    }
}
