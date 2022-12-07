package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<MessageHelper<T>> {
    private final Map<String, List<T>> mailBox = new HashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key) {
            List<T> valueList = super.get(key);
            return valueList != null ? valueList : Collections.EMPTY_LIST;
        }
    };

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(MessageHelper<T> messageHelper) {
        if (mailBox.containsKey(messageHelper.getTo())) {
            mailBox.get(messageHelper.getTo()).add(messageHelper.getContent());
        } else {
            mailBox.put(messageHelper.getTo(), new ArrayList<>(Collections.singletonList(messageHelper.getContent())));
        }
    }
}
