package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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

        Map<String, Double> sortedMap = new TreeMap<String, Double>(map);

        for (Map.Entry<String, Double> pair : sortedMap.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
