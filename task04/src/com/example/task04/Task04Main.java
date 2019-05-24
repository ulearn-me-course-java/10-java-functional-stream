package com.example.task04;
import java.io.IOException;
import java.util.*;


public class Task04Main<extend> {

    public static void main(String[] args) throws IOException {
        Map<String, ComparableInt > map = new TreeMap<>();

        try(Scanner bf = new Scanner(System.in)) {
            String comp;
            bf.useDelimiter("[-, ,!,.,\n]");
            while(bf.hasNext())
            {
               String temp = bf.next().toLowerCase();
               if(temp.length() != 0)
                   if (map.containsKey(temp)) {
                       map.get(temp).set(map.get(temp).intValue() + 1);
                   } else map.put(temp, new ComparableInt(1));
            }
        }

        map.entrySet().stream()
                .sorted(Map.Entry.<String, ComparableInt>comparingByValue().reversed())
                .limit(10)
                .forEachOrdered(x-> System.out.print(x.getKey() + "\n"));
        }
}
