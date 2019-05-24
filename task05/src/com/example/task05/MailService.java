package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<IMessage<T>> {

    private Map<String, List<T>> mailBox = new NotNullMap<>();

    public Map<String, List<T>> getMailBox() { return mailBox; }

    @Override
    public void accept(IMessage<T> message) {

        if(!mailBox.containsKey(message.getTo()))
            mailBox.put(message.getTo(), new ArrayList<>());

        mailBox.get(message.getTo()).add(message.getContent());
    }
}