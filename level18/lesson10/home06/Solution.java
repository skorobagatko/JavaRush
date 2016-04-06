package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Map<Integer, Integer> symbolsMap = new HashMap<Integer, Integer>();
        FileInputStream is = new FileInputStream(args[0]);
        int symbol = 0;
        while (is.available() > 0) {
            symbol = is.read();
            if (!symbolsMap.containsKey(symbol)) { symbolsMap.put(symbol, 1); }
            else { symbolsMap.put(symbol, symbolsMap.get(symbol)+1); }
        }

        is.close();

        Map<Integer, Integer> sortedMap = new TreeMap<>(symbolsMap);

        for (Map.Entry<Integer, Integer> pair : sortedMap.entrySet()) {
            int i = pair.getKey();
            System.out.println((char)i + " " + pair.getValue());
        }
    }
}
