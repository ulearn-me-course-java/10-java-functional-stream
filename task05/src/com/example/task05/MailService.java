package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<MailForm<T>> {
    Map<String, List<T>> mailBox = new HashMap<String, List<T>>(){

        @Override
        public List<T> get(Object key) {
            return super.get(key) == null ? new ArrayList<>() : super.get(key);
        }
    };
    @Override
    public void accept(MailForm<T> tMailForm) {
        if(mailBox.containsKey(tMailForm.getTo()))
            mailBox.get(tMailForm.getTo()).add(tMailForm.getContent());
        else {
            mailBox.put(tMailForm.getTo(), new ArrayList<>());
            mailBox.get(tMailForm.getTo()).add(tMailForm.getContent());
        }
    }

    public Map<String, List<T>> getMailBox(){
        return mailBox;
    }
}
