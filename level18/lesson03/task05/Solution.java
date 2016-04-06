package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream is = new FileInputStream(reader.readLine());
        List<Integer> bytes = new ArrayList<Integer>();

        int byteFromFile = 0;
        while (is.available() > 0) {
            byteFromFile = is.read();
            if (!bytes.contains(byteFromFile)) { bytes.add(byteFromFile); }
        }

        is.close();
        reader.close();

        Collections.sort(bytes, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o1 - o2;
            }
        });

        for (Integer i : bytes) {
            System.out.print(i + " ");
        }
    }
}
