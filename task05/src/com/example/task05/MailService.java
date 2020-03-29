package com.example.task05;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<MailContainer<T>> {

    private final Map<String, List<T>> mailBox = new CrutchMap<>();

    @Override
    public void accept(MailContainer<T> container) {
        if(mailBox.containsKey(container.getTo()))
            mailBox.get(container.getTo()).add(container.getContent());
        else {
            mailBox.put(container.getTo(), new LinkedList<T>());
            mailBox.get(container.getTo()).add(container.getContent());
        }
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }
}