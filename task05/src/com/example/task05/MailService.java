package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Server> {

    Map<String, List<T>> mailBox = new newMap<>();

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Server server) {
        if (!mailBox.containsKey(server.getTo()))
            mailBox.put(server.getTo(), new ArrayList<>());
        mailBox.get(server.getTo()).add((T) server.getContent());
    }

    public class newMap<T> extends HashMap<String, List<T>> {
        @Override
        public List<T> get(Object key) {
            List<T> box = super.get(key);
            return box == null ? new ArrayList<>() : box;
        }
    }
}
