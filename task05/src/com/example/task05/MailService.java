package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService <T> implements Consumer<IMessage> {
    private  Map<String, List<T>> box = new MessageBox<>();

    public Map<String, List<T>> getMailBox(){
        return box;
    }


    @Override
    public void accept(IMessage iMessage) {
        if(!box.containsKey(iMessage.getTo()))
            box.put(iMessage.getTo(), new ArrayList<>());
        box.get(iMessage.getTo()).add((T) iMessage.getContent());

    }
}
