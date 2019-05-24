package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<IMessage<T>> {

    private Map<String, List<T>> _mailBox = new NotNullMap<>();

    public Map<String, List<T>> getMailBox() { return _mailBox; }


    @Override
    public void accept(IMessage<T> message) {

        if(!_mailBox.containsKey(message.getTo()))
            _mailBox.put(message.getTo(), new ArrayList<>());

        _mailBox.get(message.getTo()).add(message.getContent());
    }
}

