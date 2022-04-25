package com.example.task05;


import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<AbstractMail<T>> {
    private final Map<String, List<T>> mails;

    public MailService() {
        mails = new HashMap<String, List<T>>(){
            // фиксим nullpointerexception. getordefault  получения значения, сопоставленного указанному ключу.
            // Если никакое значение не сопоставлено с предоставленным ключом, то возвращается значение по умолчанию.
            @Override
            public List<T> get(Object key) {
                return super.getOrDefault(key, Collections.emptyList());
            }
        };
    }
    @Override
    public void accept(AbstractMail<T> content) {
        // в качестве ключа берем получателя. если нашёлся - ничего не делаем
        // иначе - создаем новый список сообщений для получателя
        mails.computeIfAbsent(content.getTo(), a -> new ArrayList<>()).add(content.getContent());
    }
    public Map<String, List<T>> getMailBox() {
        return mails;
    }
}
