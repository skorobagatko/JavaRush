package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        String line = "";
        String world = "world";
        int countOfWorld = 0;
        while (fileReader.ready()) {
            line = fileReader.readLine();
            line = line.replaceAll("[!.,?]", "");
            String[] stringsOfLine = line.split(" ");
            for (String s : stringsOfLine) {
                if (s.equals(world)) countOfWorld++;
            }
        }
        fileReader.close();

        System.out.println(countOfWorld);
    }
}
