package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        double median;
        if (array.length % 2 == 0) {
            median = (array[array.length/2-1] + array[array.length/2]) / 2;
        } else {
            median = array[array.length / 2];
        }

        final double comMedian = median;
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int distance1 = (int)Math.abs(comMedian - o1);
                int distance2 = (int)Math.abs(comMedian - o2);
                if (distance1 == distance2) {
                    return o1 - o2;
                }
                return distance1 - distance2;
            }
        });

        return array;
    }
}
