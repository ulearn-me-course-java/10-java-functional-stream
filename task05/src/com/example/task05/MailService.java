package com.example.task05;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Content<T>> {
    private Map<String, List<T>> mailBox = new HashMapWithoutNPE<>();

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Content<T> mailMessage) {
        String mailMessageTo = mailMessage.getTo();
        if (!mailBox.containsKey(mailMessageTo))
            mailBox.put(mailMessageTo, new ArrayList<>());
        mailBox.get(mailMessageTo).add(mailMessage.getContent());
    }
}
