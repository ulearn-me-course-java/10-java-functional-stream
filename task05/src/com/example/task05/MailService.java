package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService <T> implements Consumer<Mail> {

    Map<String, List<T>> mailBox = new EmtyableMap<>();

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    public void accept(Mail service) {
        if (!mailBox.containsKey(service.getTo())) {
            mailBox.put(service.getTo(), new ArrayList<>());
        }
        if (mailBox.get(service.getTo()) != null) {
            mailBox.get(service.getTo()).add((T)service.getContent());
        }
    }

    public class EmtyableMap<T> extends HashMap<String, List<T>>{

        public List<T> get(Object key){
            List<T> temp = super.get(key);
            return temp == null ? Collections.emptyList() : temp;
        }
    }
}


