package com.example.task05;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<IMessage<T>> {

    private Map<String, List<T>> mail = new EmptyMap<>();
    public Map<String, List<T>> getMailBox(){
        return mail;
    }

    @Override
    public void accept(IMessage mailMessage) {
        String mailTo = mailMessage.getTo();
        if (!mail.containsKey(mailTo)){
            mail.put(mailTo, new ArrayList<>());
        }
        mail.get(mailTo).add((T)mailMessage.getContent());
    }
}
