package com.example.task05;

import javax.xml.ws.Service;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MailService<T> implements Consumer<T> {
    public List<MailMessage<T>> messages;
    @Override
    public void accept(Object o) {
        messages.add((MailMessage<T>) o);
    }
}
