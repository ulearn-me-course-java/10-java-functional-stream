package com.example.task05;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<IService<T>> {
    private Map<String, List<T>> mailBox = new HashMapEx<>();

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(IService<T> mailMessage) {
        String messageTo = mailMessage.getTo();

        if (!mailBox.containsKey(messageTo))
            mailBox.put(messageTo, new ArrayList<>());

        mailBox.get(messageTo).add(mailMessage.getContent());
    }
}