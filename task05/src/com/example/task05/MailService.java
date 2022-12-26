package com.example.task05;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MailService<T> implements Consumer<Mail<T>>
{
    private Map<String, List<T>> mailBox = new HashMap<String, List<T>>()
    {
        @Override
        public List<T> get(Object key)
        {
            List<T> valueList = super.get(key);
            return valueList != null ? valueList : new ArrayList<T>();
        }
    };


    public Map<String, List<T>> getMailBox()
    {
        return mailBox;
    }

    @Override
    public void accept(Mail<T> tMail)
    {
        if (mailBox.containsKey(tMail.getTo()))
        {
            List<T> list = mailBox.get(tMail.getTo());
            list.add(tMail.getContent());
        }
        else
        {
            List<T> list = new ArrayList<>();
            list.add(tMail.getContent());
            mailBox.put(tMail.getTo(), list);
        }

    }
}
