package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<BaseForm<T>> {
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
    public void accept(BaseForm<T> form){
        if(MailBox.containsKey(form.getTo())){
            MailBox.get(form.getTo()).add(form.getContent());
        }else{
            ArrayList<T> arrayList = new ArrayList<>();
            arrayList.add(form.getContent());
            MailBox.put(form.getTo(), arrayList);
        }
    }

}