package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        double backspaces = 0.0, symbols = 0.0;
        FileInputStream is = new FileInputStream(args[0]);
        while (is.available() > 0) {
            int byteCode = is.read();
            if (byteCode == 32) { backspaces++; }
            symbols++;
        }
        double result = backspaces / symbols * 100;
        String format = new DecimalFormat("###.##").format(result);
        System.out.print(Math.round(result));

        is.close();
    }
}
