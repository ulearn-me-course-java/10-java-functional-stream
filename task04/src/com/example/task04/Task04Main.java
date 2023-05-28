package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.lines()
                .map(String::toLowerCase) // преоброзавние в строку мелких
                .flatMap(x -> Stream.of(x.split("\\P{L}+"))) // преоброзование в поток (массив строк)
                //  \P Знаки пунктуации: Один из !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
                // {L} - весь string
                //  + один или несколько раз
                .filter(x -> !x.isEmpty()) // убераем пустые
                .collect(Collectors.groupingBy(n -> n, Collectors.counting())) // груперуем по их кол-ву
                .entrySet()
                //entrySet(): возвращает набор элементов коллекции. Все элементы представляют объект Map.Entry
                .stream()
                // превращаем это в поток
                .sorted(Map.Entry.comparingByKey())
                // Сортируем по ключам (Возвращает компаратор, который сравнивает Map.Entry в естественном порядке по ключу.)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                //Возвращает компаратор, который сравнивает Map.Entry по значению, используя данный компаратор.
                // (Возвращает компаратор, который налагает порядок, обратный естественному порядку.)
                // Налагать это: несов. перех. 1.Класть что-либо сверху или поверх чего-либо
                .limit(10)
                .forEach(t -> System.out.print(t.getKey() + "\n"));
    }

}
//flatMap(Function<T, Stream<R>> mapper) — как и в случае с map, служат для преобразования в примитивный стрим.

//map(Function mapper) даёт возможность создать функию с помощью которой мы будем изменять каждый элемент и пропускать его
// дальше (Функциональный интерфейс Function<T,R> представляет функцию перехода от объекта типа T к объекту типа R)
