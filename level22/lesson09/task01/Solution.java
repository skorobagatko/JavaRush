package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "windows-1251"));
        StringBuilder sb = new StringBuilder("");
        while (fileReader.ready()) {
            sb.append(fileReader.readLine());
            sb.append(" ");
        }
        fileReader.close();

        String[] words = sb.toString().split(" ");
        sb = new StringBuilder(""); // обнуляю стрингбилдер для дальнейшего его использования в цикле
        Map<String, String> map = new LinkedHashMap<String, String>();
        for (String s1 : words) {
            for (String s2 : words) {
                if (s1.length() > 0) {
                    sb = new StringBuilder(s1).reverse();
                    if (sb.toString().equals(s2) && !s1.equals(s2)) {   // как оказалось задача не проходила тестирование из-за отстутствия в этой строке проверки
                        if (!map.containsKey(s1) && !map.containsKey(sb.toString())) {  // на то, что обе оригинальных строки не были одинаковыми
                            map.put(s1, s2);                            // т.е. к примеру два слова "еще еще" (которые одинаковы и до и после реверса)
                        }                                               // не должны учитываться при добавлении в лист результатов
                    }
                }
            }
        }

        for (Map.Entry<String, String> elem : map.entrySet()) {
            Pair pair = new Pair();
            pair.first = elem.getKey();
            pair.second = elem.getValue();
            result.add(pair);
        }

        for (Pair pair : result) {
            System.out.println(pair.toString());
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
