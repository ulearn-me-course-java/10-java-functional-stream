package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

    public class MailService<T> implements Consumer<Base<T>>{
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

        public void accept(Base<T> from) {
            if (mailBox.containsKey(from.getTo()))
                mailBox.get(from.getTo()).add(from.getContent());
            else{
                ArrayList<T> arr = new ArrayList<>();
                arr.add(from.getContent());
                mailBox.put(from.getTo(), arr);
            }
        }
    }
