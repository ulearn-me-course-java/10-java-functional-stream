package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<MailParcel<T>> {

    private final Map<String, List<T>> mailbox = new HashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key) {
            List<T> list = super.get(key);
            return list != null ? list : Collections.emptyList();
        }
    };

    @Override
    public void accept(MailParcel<T> tMailParcel) {
        if(mailbox.containsKey(tMailParcel.getTo())) // Проверяем наличие ключа
            mailbox.get(tMailParcel.getTo()).add(tMailParcel.getContent()); // Если есть - пополняем лист свежим значением
        else
            mailbox.put(tMailParcel.getTo(), new ArrayList<>(Collections.singletonList(tMailParcel.getContent()))); // Если нет - создаём новую пару ключ-значение
    }

    public Map<String, List<T>> getMailBox() { // Метод возврата всех значений сервиса
        return mailbox;
    }
}