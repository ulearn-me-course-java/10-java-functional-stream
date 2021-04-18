package com.example.task04;

import java.io.*;
import java.util.*;

public class Task04Main {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        new BufferedReader(new InputStreamReader(System.in))
                .lines()
                .flatMap(x -> Arrays.stream(x.split("[^a-zA-Zа-яА-ЯёЁ]")))
                .filter(word -> !word.equals(""))
                .map(word -> word.toLowerCase(Locale.ROOT))
                .forEach(word -> {
                    if(!map.containsKey(word)) {
                        map.put(word, 1);
                    } else {
                        Integer old = map.get(word);
                        map.put(word, ++old);
                    }
                });
        Comparator<Map.Entry<String, Integer>> sort = Comparator.comparing(Map.Entry::getValue); //
        Comparator<Map.Entry<String, Integer>> thenBy = Comparator.comparing(Map.Entry::getKey); //так ужасно из-за компилятора :(
        map.entrySet().stream()
                .sorted(sort.reversed().thenComparing(thenBy))
                .limit(10)
                .forEach(x -> System.out.print(x.getKey() + '\n'));
    }
}
