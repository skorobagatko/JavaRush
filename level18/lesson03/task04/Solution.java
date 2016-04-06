package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        Map<Integer, Integer> bytes = new HashMap<Integer, Integer>();
        Map<Integer, Integer> min = new HashMap<Integer, Integer>();
        int key = 0;
        int value = 0;
        // Читаем байты и заполняем ими мапу (поле key), одновременно считаем кол-во повторов и записываем их в value мапы
        while (fis.available() > 0) {
            key = fis.read();
            if (bytes.containsKey(key)) {
                value = bytes.get(key);
                bytes.put(key, value+1);
            } else { bytes.put(key, 1); }
        }
        fis.close();
        reader.close();

        int minValue = 1;
        for (Map.Entry<Integer, Integer> pair : bytes.entrySet()) {
            if (pair.getValue() == minValue) {
                if (!min.containsKey(pair.getKey())) { min.put(pair.getKey(), pair.getValue()); }
            }
        }

        for (Integer keys : min.keySet()) {
            System.out.print(keys + " ");
        }
    }
}
