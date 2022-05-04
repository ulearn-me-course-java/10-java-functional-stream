package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Content<T>>
{
    private final Map<String, List<T>> mailBox = new HashMap<String, List<T>>()
    {
        @Override
        public List<T> get(Object key)
        {
            return super.getOrDefault(key, Collections.emptyList());
        }
    };

    @Override
    public void accept(Content<T> t)
    {
        if (mailBox.containsKey(t.getTo()))
        {
            mailBox.get(t.getTo()).add(t.getContent());
        } else
        {
            ArrayList<T> mailBox = new ArrayList<>();
            mailBox.add(t.getContent());
            this.mailBox.put(t.getTo(), mailBox);
        }
    }

    public Map<String, List<T>> getMailBox()
    {
        return mailBox;
    }
}
