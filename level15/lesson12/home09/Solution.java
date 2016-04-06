package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        int i = url.indexOf("?");
        // создаем подстроку после символа "?" и разбиваем её на массив строк (разделитель - "&"), после этого добавляем созданный массив в лист
        List<String> values = new ArrayList<String>(Arrays.asList(url.substring(i+1).split("&")));
        // выводим в консоль часть каждой строки до знака "=", иначе, если знака "=" в строке нет - выводим строку полностью
        for (int i1 = 0; i1 < values.size(); i1++)
        {
            String s = values.get(i1);
            String substring = null;
            if (s.contains("="))
            {
                int indexOfEqually = s.indexOf("=");
                substring = s.substring(0, indexOfEqually);
            } else
            {
                substring = s;
            }
            if (i1 == values.size()-1) { System.out.println(substring); }
            else { System.out.print(substring + " "); }
        }

        for (String s : values) {
            if (s.startsWith("obj=")) {
                int index = s.indexOf("=");
                String substring = s.substring(index+1);
                try {
                    alert(Double.parseDouble(substring));
                } catch (NumberFormatException e) {
                    alert(substring);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
