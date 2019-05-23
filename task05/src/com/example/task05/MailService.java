package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

class MailService <ContentType> implements Consumer<ContentContainer<ContentType>> {
    class NewHashMap<ItemType> extends HashMap<String, List<ItemType>> {
        public List<ItemType> get(Object to) {
            List<ItemType> list = super.get(to);
            return (list == null) ? new ArrayList<ItemType>() : list;
        }
    }

    private Map<String, List<ContentType>> mailBox = new NewHashMap<ContentType>();

    public Map<String, List<ContentType>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(ContentContainer<ContentType> tServer) {
        String to = tServer.getTo();

        if (!mailBox.containsKey(to))
            mailBox.put(to, new ArrayList<ContentType>());

        mailBox.get(to).add(tServer.getContent());
    }

}
