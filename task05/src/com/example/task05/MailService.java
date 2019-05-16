package com.example.task05;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class MailService<T> implements Consumer<MailConsumer> {
    private List<MailConsumer> mailConsumers = new ArrayList<>();

    @Override
    public void accept(MailConsumer mailConsumer) {
        mailConsumers.add(mailConsumer);
    }

    public Map<String, List<T>> getMailBox() {
        return mailConsumers
                .stream()
                .collect(Collectors.groupingBy(MailConsumer::getTo,
                        HackMap::new,
                        Collectors.mapping(MailConsumer<T>::getContent, toList())));
    }
}
