package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Base<T>> {
    private final Map<String, List<T>> mailBox = new HashMap<String, List<T>>(){
        @Override
        public List<T> get(Object key) {
            List<T> list = super.get(key);
            return list != null ? list : new ArrayList<>();
        }
    };

    public MailService() {
        super();
    }

    public Map<String, List<T>> getMailBox(){
        return this.mailBox;
    }

    public void accept(Base<T> form) {
        if (mailBox.containsKey(form.getTo()))
            mailBox.get(form.getTo()).add(form.getContent());
        else{
            ArrayList<T> arr = new ArrayList<>();
            arr.add(form.getContent());
            mailBox.put(form.getTo(), arr);
        }
    }
}