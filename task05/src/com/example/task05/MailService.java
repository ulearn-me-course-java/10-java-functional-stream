package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<TItem> implements Consumer<MailServiceable<TItem>> {
    private MailMap<TItem> mailBox = new MailMap<>();

    public Map<String, List<TItem>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(MailServiceable<TItem> o) {
        if (mailBox.containsKey(o.getTo())) {
            mailBox.get(o.getTo()).add(o.getContent());
        } else {
            mailBox.put(o.getTo(), new ArrayList<>(Arrays.asList(o.getContent())));
        }
    }
}
