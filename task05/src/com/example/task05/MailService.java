package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService <T> implements Consumer<MailContainer<T>> {

    private NotNullMap<T> mailBox = new NotNullMap<>();

    @Override
    public void accept(MailContainer<T> t) {
        if (mailBox.containsKey(t.getTo())) {
            List<T> recieversList = mailBox.get(t.getTo());
            recieversList.add(t.getMessage());
        } else {
            ArrayList<T> arrayList = new ArrayList<>();
            arrayList.add(t.getMessage());
            mailBox.put(t.getTo(), arrayList);
        }
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }
}
