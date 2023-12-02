package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<BaseObjClass<T>> {
    private final Map<String, List<T>> MailBox = new HashMap<String, List<T>>(){
        @Override
        public List<T> get(Object key) {
            List<T> list = super.get(key);
            return list != null ? list : new ArrayList<>();
        }
    };
    public Map<String, List<T>> getMailBox() {
        return MailBox;
    }

    @Override
    public void accept(BaseObjClass<T> baseObjClass){
        if (MailBox.containsKey(baseObjClass.getTo())) {
            MailBox.get(baseObjClass.getTo()).add(baseObjClass.getContent());
        } else {
            ArrayList<T> arrayList = new ArrayList<>();
            arrayList.add(baseObjClass.getContent());
            MailBox.put(baseObjClass.getTo(), arrayList);
        }
    }
}
