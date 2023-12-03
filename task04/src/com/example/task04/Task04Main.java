package com.example.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    /*
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    - Создается BufferedReader для чтения строк из стандартного ввода.

    br.lines() - Получает поток строк из BufferedReader.

    .map(String::toLowerCase) - Преобразует каждую строку в нижний регистр.

    .flatMap(x -> Stream.of(x.split("[^a-zа-яё0-9]"))):
    Разбивает каждую строку на слова, используя регулярное выражение "[^a-zа-яё0-9]" (все символы, кроме букв и цифр),
    и создает поток слов.

    .filter(x -> !x.isEmpty()) - Фильтрует пустые слова.

    .collect(Collectors.groupingBy(n -> n, Collectors.counting())):
    Группирует слова по их значению (т.е., по слову) и подсчитывает количество каждого слова.

    .entrySet().stream() - Создает поток из записей карты (ключ-значение).

    .sorted(Comparator.comparingLong((ToLongFunction<Map.Entry<String, Long>>)Map.Entry::getValue) .reversed() .thenComparing(Map.Entry::getKey)):
    Сортирует записи карты сначала по значению (количеству встречаемости слова) в обратном порядке (от большего к меньшему).
    При равенстве количества слов, сортировка происходит по ключу (слову) в естественном порядке (по алфавиту).

    .limit(10) - Ограничивает поток до первых 10 элементов (топ-10 наиболее часто встречающихся слов).

    .forEach(x -> System.out.print(x.getKey() + '\n'))
    - Для каждого элемента потока выводит ключ (слово) на экран, каждое слово с новой строки.

    Таким образом, этот код обрабатывает ввод пользователя, подсчитывает количество каждого уникального слова
    и выводит наиболее часто встречающиеся слова в порядке убывания их частоты, ограничиваясь только 10 наиболее часто встречающимися словами.
     */
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.lines()
                .map(String::toLowerCase)
                .flatMap(x -> Stream.of(x.split("[^a-zа-яё0-9]")))
                .filter(x -> !x.isEmpty())
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong((ToLongFunction<Map.Entry<String, Long>>)Map.Entry::getValue)
                        .reversed()
                        .thenComparing(Map.Entry::getKey))
                .limit(10)
                .forEach(x -> System.out.print(x.getKey() + '\n'));
    }
}
