package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Server<T>> {
    //получатель - сообщения
    private Map<String, List<T>> mailBox = new NewHashMap<>();

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Server<T> tServer) {
        String to = tServer.getTo();
        if (!mailBox.containsKey(to))
            mailBox.put(to, new ArrayList<>());
        mailBox.get(to).add(tServer.getContent());
    }

    class NewHashMap<T> extends HashMap<String, List<T>> {
        public List<T> get(Object to) {
            List<T> list = super.get(to);
            return list == null ? new ArrayList<>() : list;
        }
    }
}

