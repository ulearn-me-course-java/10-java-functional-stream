package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MailBox<T, J> extends HashMap<T, List<J>> {
    @Override
    public List<J> get(Object key) {
        List<J> list = super.get(key);
        return list == null ? new ArrayList<>() : list;
    }
}
