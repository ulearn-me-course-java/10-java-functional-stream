package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<MailPackage<T>> {

    private final Map<String, List<T>> mailBox = new HashMap<String, List<T>>(){
        @Override
        public List<T> get(Object key){
            List<T> list = super.get(key);
            return list != null ? list : Collections.emptyList();
        }
    };

    @Override
    public void accept(MailPackage<T> mailPackage){
        if(mailBox.containsKey(mailPackage.getTo())){
            mailBox.get(mailPackage.getTo()).add(mailPackage.getContent());
        } else{
            mailBox.put(mailPackage.getTo(), new ArrayList<>(Collections.singletonList(mailPackage.getContent())));
        }
    }

    public Map<String, List<T>> getMailBox(){
        return mailBox;
    }
}
