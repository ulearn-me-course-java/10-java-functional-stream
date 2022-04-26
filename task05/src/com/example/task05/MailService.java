package com.example.task05;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MailService<T> implements Consumer<MailServiceElement<T>> {
    List<MailServiceElement<T>> list = new ArrayList<>();

    public Map<String, List<T>> getMailBox() {
        return list.stream().collect(
                Collectors.groupingBy(MailServiceElement::getTo, MailServiceContentMap<T>::new,
                        Collectors.mapping(MailServiceElement::getContent,
                                Collectors.toList())));
    }

    @Override
    public void accept(MailServiceElement<T> element) {
        list.add(element);
    }
}
