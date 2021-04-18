package com.example.task04;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Task04Main {

    public static void main(String[] args) {
        /*FrequentlyRepeatedWords f = new FrequentlyRepeatedWords();
        f.addCount("fgi");
        f.addCount("b");
        f.addCount("fgi");
        f.addCount("fgi");
        f.addCount("c");
        f.addCount("a");
        f.addCount("fgi");
        f.addCount("fgi");
        f.map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                 .forEach(x -> {});*/
        getFrequentlyRepeatedWords();
    }

    public static void getFrequentlyRepeatedWords(){
        FrequentlyRepeatedWords f = new FrequentlyRepeatedWords();
        new BufferedReader(new InputStreamReader(System.in))
                .lines()
                .forEach(x -> Arrays.stream(x.toLowerCase()
                        .split("[^a-zа-яё]"))
                        .forEach(w -> f.addCount(w)));
        Comparator<String> comp = String::compareTo;
        f.map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing((x, y) -> comp.compare(x.getKey(), y.getKey())))
                .filter(x -> !x.getKey().isEmpty())
                .limit(10)
                .forEach(x -> System.out.print(x.getKey() + "\n"));
    }

    public static class FrequentlyRepeatedWords{
        public Map<String, Integer> map = new HashMap<>();

        public void addCount(String word){
            if(map.containsKey(word)) {
                Integer in = map.get(word);
                map.put(word, ++in);
            }
            else
                map.put(word, 1);
        }
    }

}
