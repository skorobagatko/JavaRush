package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static void main(String[] args) {
        String[] tokens = getTokens("level22.lesson13.task01", ".");

        System.out.println(Arrays.toString(tokens));
    }

    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> list = new ArrayList<String>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }
        // т.к. нам заранее неизвестна длина массива, который нужно создать для его возврата из метода,
        // то, используем ArrayList и в return конвертируем его в массив (массив создаем в скобках)
        return list.toArray(new String[list.size()]);
    }
}
