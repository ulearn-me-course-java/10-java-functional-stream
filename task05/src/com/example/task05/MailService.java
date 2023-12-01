package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService <T> implements Consumer {
    Map<String,List<T>> mailBox = new SafetyKeyStringMap<>();

    public Map<String, List<T>> getMailBox(){
        return mailBox;
    }
    @Override
    public void accept(Object obj) {
        Letter letter = (Letter) obj;
        mailBox.putIfAbsent(letter.getTo(),new ArrayList<>());
        mailBox.get(letter.getTo()).add((T)letter.getContent());
    }
}
