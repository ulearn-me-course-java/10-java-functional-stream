package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService <T> implements Consumer<MailMain<T>> {
    private final Map<String, List<T>> mailBox = new HashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key){
            List<T> content = super.get(key);
            return content == null ? new ArrayList<>() : content;
        }
    };

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(MailMain<T> mailMain){
        if (mailBox.containsKey(mailMain.getTo()))
            mailBox.get(mailMain.getTo()).add(mailMain.getContent());
        else
        {
            List<T> list = new ArrayList<>();
            list.add(mailMain.getContent());
            mailBox.put(mailMain.getTo(), list);
        }
    }
}
