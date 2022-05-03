package com.example.task05;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MailService<T> implements Consumer<Message<T>> {
    List<Message<T>> list = new ArrayList<>();

    public Map<String, List<T>> getMailBox() {
        return list.stream().collect(
                Collectors.groupingBy(Message::getTo, MailServiceContentMap<T>::new,
                        Collectors.mapping(Message::getContent,
                                Collectors.toList())));
    }

    @Override
    public void accept(Message<T> element) {
        list.add(element);
    }
}
