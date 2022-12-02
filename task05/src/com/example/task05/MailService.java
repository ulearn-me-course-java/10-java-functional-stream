package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<MailParcel<T>> {

    private final Map<String, List<T>> mailbox = new HashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key) {
            List<T> list = super.get(key);
            return list != null ? list : Collections.emptyList();
        }
    };

    @Override
    public void accept(MailParcel<T> tMailParcel) {
        if(mailbox.containsKey(tMailParcel.getTo()))
            mailbox.get(tMailParcel.getTo()).add(tMailParcel.getContent());
        else
            mailbox.put(tMailParcel.getTo(), new ArrayList<>(Collections.singletonList(tMailParcel.getContent())));
    }

    public Map<String, List<T>> getMailBox() {
        return mailbox;
    }
}
