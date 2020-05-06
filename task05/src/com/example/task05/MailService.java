package com.example.task05;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<IMessage> {
    private final Map<String, List<T>> mailBox = new ExcludeEmptyMap<>();

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(IMessage mailMessage) {
        String mailTo = mailMessage.getTo();
        if (!mailBox.containsKey(mailTo))
            mailBox.put(mailTo, new ArrayList<>());
        mailBox.get(mailTo).add((T) mailMessage.getContent());
    }
}
