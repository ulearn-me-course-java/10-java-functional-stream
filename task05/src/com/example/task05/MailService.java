package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Message<T>> {

    private final Map<String, List<T>> mailCollector = new HashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key) {
            List<T> list = super.get(key);
            return list != null ? list : new ArrayList<>();
        }
    };

    public MailService() {
        super();
    }

    public Map<String, List<T>> getMailCollector() {
        return this.mailCollector;
    }
    @Override
    public void accept(Message<T> frame) {

        if (mailCollector.containsKey(frame.getTo()))
            mailCollector.get(frame.getTo()).add(frame.getContent());
        else {
            ArrayList<T> arr = new ArrayList<>();
            arr.add(frame.getContent());
            mailCollector.put(frame.getTo(), arr);
        }
    }
}
