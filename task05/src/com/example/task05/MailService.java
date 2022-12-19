package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<MailForm<T>> {
    private final Map<String, List<T>> mailBox = new HashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key) {
            List<T> list = super.get(key);
            return list == null ? new ArrayList<>() : list;
        }
    };

    public Map<String, List<T>> getMailBox() {
        return this.mailBox;
    }

    @Override
    public void accept(MailForm<T> tForm) {
        if (this.mailBox.containsKey(tForm.getTo())) {
            List<T> list = this.mailBox.get(tForm.getTo());
            list.add(tForm.getContent());
        } else {
            List<T> content = new ArrayList<>(Collections.singletonList(tForm.getContent()));
            this.mailBox.put(tForm.getTo(), content);
        }
    }
}