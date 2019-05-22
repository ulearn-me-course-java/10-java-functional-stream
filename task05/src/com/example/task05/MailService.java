package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<IFromToContent>{
    private Map<String, List<T>> mailBox = new HashMapp<>();

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(IFromToContent tiFromToContent) {
        String mailTo = tiFromToContent.getTo();
        if (!mailBox.containsKey(mailTo))
            mailBox.put(mailTo, new ArrayList<>());
        mailBox.get(mailTo).add((T)tiFromToContent.getContent());
    }
}