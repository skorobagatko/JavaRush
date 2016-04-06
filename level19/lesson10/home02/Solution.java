package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file = args[0];
        Map<String, Double> map = new HashMap<String, Double>();

        BufferedReader readFile = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String[] line;
        while (readFile.ready()) {
            line = readFile.readLine().split(" ");
            String key = line[0];
            double value = Double.parseDouble(line[1]);
            if (map.containsKey(key)) { map.put(key, map.get(key)+value); }
            else { map.put(key, value); }
        }
        readFile.close();


        double maxValue = 0;
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue() > maxValue) { maxValue = pair.getValue(); }
        }

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue() == maxValue) {
                System.out.println(pair.getKey());
            }
        }

    }
}
