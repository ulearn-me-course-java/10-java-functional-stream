package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<IService<T>> {

    private Map<String, List<T>> mailBox = new ImprovedHashMap<>();

    public Map<String, List<T>> getMailBox(){
        return mailBox;
    }

    @Override
    public void accept(IService<T> service) {
        if(mailBox.containsKey(service.getTo()))
            mailBox.get(service.getTo()).add(service.getContent());
        else{
            List<T> content = new ArrayList<>();
            content.add(service.getContent());
            mailBox.put(service.getTo(), content);
        }

    }
}
