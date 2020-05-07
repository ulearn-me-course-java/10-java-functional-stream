package com.example.task05;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Message> {
    private Map<String, List<T>> mailBox = new OverthrowNullMap<>();

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Message message) {
        String mailToWhom = message.getTo();
        if (!mailBox.containsKey(mailToWhom))
            mailBox.put(mailToWhom, new ArrayList<>());
        mailBox.get(mailToWhom).add((T)message.getContent());
    }
}
