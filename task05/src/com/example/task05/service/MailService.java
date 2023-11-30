package com.example.task05.service;

import com.example.task05.model.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Message<T>> {
    HashMap<String, List<T>> mailBox = new HashMap<String, List<T>>(){

        @Override
        public List<T> get(Object key) {
            return super.get(key) == null ? new ArrayList<>() : super.get(key);
        }
    };

    public MailService(){

    }
    public HashMap<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Message<T> message) {
        if(!mailBox.containsKey(message.getTo())) {
            mailBox.put(message.getTo(), new ArrayList<>());
            mailBox.get(message.getTo()).add(message.getContent());
        } else {
            mailBox.get(message.getTo()).add(message.getContent());
        }
    }

}
