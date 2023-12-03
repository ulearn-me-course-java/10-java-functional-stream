package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<IMail<T>>
{
    private final Map<String, List<T>> mailBox = new HashMap<String, List<T>>()
    {
        @Override
        public List<T> get(Object key)
        {
            List<T> list = super.get(key);
            return list == null ? new ArrayList<>() : list;
        }
    };

    public Map<String, List<T>> getMailBox()
    {
        return this.mailBox;
    }

    @Override
    public void accept(IMail<T> form)
    {
        if (this.mailBox.containsKey(form.getTo()))
        {
            List<T> list = this.mailBox.get(form.getTo());
            list.add(form.getContent());
        } else
        {
            List<T> content = new ArrayList<>(Collections.singletonList(form.getContent()));
            this.mailBox.put(form.getTo(), content);
        }
    }
}
