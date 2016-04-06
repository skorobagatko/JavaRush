package com.javarush.test.level25.lesson09.task03;

import java.util.Arrays;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        // Будем работать с копией оригинального исключения
        Throwable copy = e;
        // Определяем размер будущего массива, который будет содержать всю цепочку исключений
        int arraySize = 0;
        while (copy != null) {
            arraySize++;
            copy = copy.getCause();
        }
        copy = e;
        // Порядок исключений в массиве будет обратным оригинальному
        Throwable[] reverseCauseOrder = new Throwable[arraySize];
        for (int i = reverseCauseOrder.length-1; i >= 0; i--) {
            reverseCauseOrder[i] = copy;
            copy = copy.getCause();
        }
        for(Throwable elem : reverseCauseOrder) {
            System.out.println(elem);
        }

    }
}
