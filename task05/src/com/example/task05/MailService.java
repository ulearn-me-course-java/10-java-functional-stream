package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MailService<T> {
    Map<String, List<T>> messages = new HashMap<>();
    private List<T> ExtractMessages(String name, MailMessage message){
        List<T> e = messages.get(name);
        if (e == null) e = new ArrayList<T>();
        e.add((T)message.getContent());
        return e;
    }
    private List<T> ExtractSalaries(String name, Salary x){
        List<T> e = messages.get(name);
        if (e == null) e = new ArrayList<T>();
        e.add((T)x.getSalary());
        return e;
    }
    public void AddSalary(Salary x){
        messages.put(x.getTo(), ExtractSalaries(x.getTo(), x));
    }
    public void AddMailMessage(MailMessage x){
        messages.put(x.getTo(), ExtractMessages(x.getTo(), x));
    }

    public Map<String, List<T>> getMailBox(){
        return messages;
    }
}
