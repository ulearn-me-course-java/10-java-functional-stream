package com.example.task04;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task04Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, "UTF-8")
                .useDelimiter("[^\\p{L}\\p{Digit}]+");

        HashMap<String, Integer> hashMap = new HashMap<>();
        scanner.forEachRemaining(s -> hashMap.merge(s.toLowerCase(), 1, Integer::sum));
        hashMap.entrySet().stream()
                .sorted(descendingFrequencyOrder())
                .limit(Math.min(hashMap.size(), 10))
                .map(Map.Entry::getKey)
                .forEach(x->System.out.print(x+'\n'));
    }

    private static Comparator<Map.Entry<String, Integer>> descendingFrequencyOrder() {
        return Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                .reversed()
                .thenComparing(Map.Entry::getKey);
    }
}

