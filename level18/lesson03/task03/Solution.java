package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        Map<Integer, Integer> bytes = new HashMap<Integer, Integer>();
        Map<Integer, Integer> max = new HashMap<Integer, Integer>();
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
        // Определяем максимальное value
        int maxValue = 0;
        for (Map.Entry<Integer, Integer> pair : bytes.entrySet()) {
            if (pair.getValue() > maxValue) {
                maxValue = pair.getValue();
            }
        }
        // Ищем в основной мапе keys с максимальным value и добавляем их в отдельнцю мапу
        for (Map.Entry<Integer, Integer> pair : bytes.entrySet()) {
            if (pair.getValue() == maxValue) {
                if (!max.containsKey(pair.getKey())) { max.put(pair.getKey(), pair.getValue()); }
            }
        }
        // Вывод на экран
        for (Integer keys : max.keySet()) {
            System.out.print(keys + " ");
        }
    }
}
