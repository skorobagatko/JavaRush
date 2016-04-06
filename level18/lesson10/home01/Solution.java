package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int count = 0;
        while (fileInputStream.available() > 0) {
            int bytes = fileInputStream.read();
            if (bytes >= 65 && bytes <= 90 || bytes >= 97 && bytes <= 122) count++;
        }
        System.out.println(count);
        fileInputStream.close();
    }
}
