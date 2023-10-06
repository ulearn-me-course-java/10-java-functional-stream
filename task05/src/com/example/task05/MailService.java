package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<MailForm<T>> {

    private final Map<String, List<T>> mailBox;

    public MailService() {
        mailBox = new HashMap<String, List<T>>() {
            @Override
            public List<T> get(Object key) {
                List<T> list = super.get(key);
                return list == null ? new ArrayList<>() : list;
            }
        };
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(MailForm<T> mailForm) {
        if (mailBox.containsKey(mailForm.getTo())) {
            mailBox.get(mailForm.getTo()).add(mailForm.getContent());
        } else {
            ArrayList<T> arr = new ArrayList<>();
            arr.add(mailForm.getContent());
            mailBox.put(mailForm.getTo(), arr);
        }
    }
}
