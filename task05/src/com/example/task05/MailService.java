package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<MailForm<T>> {

    private final Map<String, List<T>> mailBox = new MailBox<String, T>();

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(MailForm<T> mailForm) {
        mailBox.putIfAbsent(mailForm.getTo(), new ArrayList<>());
        mailBox.get(mailForm.getTo()).add(mailForm.getContent());
    }
}
