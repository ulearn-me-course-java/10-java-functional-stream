package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<BaseSet<T>> {
    Map<String, List<T>> mailBox = new HashMap<String, List<T>>(){
        @Override
        public List<T> get(Object key) {
            List<T> list = super.get(key);
            return list != null ? list : new ArrayList<>();
        }
    };
    @Override
    public void accept(BaseSet<T> message) {
        String from = message.getTo();
        T content = message.getContent();
        if(mailBox.containsKey(from)){
            mailBox.get(from).add(content);
        }
        else{
            mailBox.put(from, new ArrayList<>());
            mailBox.get(from).add( content);
        }
    }
    public Map<String, List<T>> getMailBox(){
        return mailBox;
    }
}
