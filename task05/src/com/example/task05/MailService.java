package com.example.task05;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Message<T>> {
    private final Map<String, List<T>> mailBox = new TreeMap<String, List<T>>(){
        @Override
        public List<T> get(Object key) {
            if (super.get(key) == null) {
                return new ArrayList<>();
            }
            return super.get(key);
        }
    };

    public Map<String, List<T>> getMailBox(){
        return mailBox;
    }
    @Override
    public void accept(Message<T> o) {
        if(mailBox.containsKey(o.getTo())){
            mailBox.get(o.getTo()).add((T)o.getContent());
        }
        else {
            List<T> list = new ArrayList<T>();
            list.add((T)o.getContent());
            mailBox.put(o.getTo(), list);
        }
    }
}
