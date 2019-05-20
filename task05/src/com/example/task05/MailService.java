package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Dispatched> {
    private Map<String, List<T>> mailBox = new MyMap<>();

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Dispatched service) {
        if (!mailBox.containsKey(service.getTo())) {
            mailBox.put(service.getTo(), new ArrayList<>());
        }
        if (mailBox.get(service.getTo()) != null) {
            mailBox.get(service.getTo()).add((T)service.getContent());
        }

    }


    public class MyMap<T> extends HashMap<String, List<T>> {

        public List<T> get(Object key) {
            List<T> v = super.get(key);
            return v == null ? new ArrayList<>() : v;
        }
    }

}
