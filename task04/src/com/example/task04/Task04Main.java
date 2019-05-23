package com.example.task04;
import java.io.IOException;
import java.util.*;


public class Task04Main<extend> {

    public static void main(String[] args) throws IOException {
        Map<String, ComInt> map = new TreeMap<>();

        try(Scanner bf = new Scanner(System.in)) {
            String comp;
            bf.useDelimiter("[-, ,!]");
            while(bf.hasNext())
            {
               String temp = bf.next().toLowerCase();
               if(map.containsKey(temp)) {
                   map.get(temp).set(map.get(temp).intValue() + 1);
               }
               else map.put(temp, new ComInt(1));
            }
        }
        map.entrySet().stream()
                .sorted(Map.Entry.<String, ComInt>comparingByValue().reversed())
                .limit(10)
                .forEachOrdered(x-> System.out.println(x.getKey()));
        }
}
