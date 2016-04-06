package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);

        testString.printSomething();

        System.setOut(consoleStream);

        String line = outputStream.toString().replaceAll("[\\n\\r]", "");
        String[] lines = line.split(" ");

        int a = 0, b = 0, c = 0;
        a = Integer.parseInt(lines[0]);
        b = Integer.parseInt(lines[2]);

        switch (lines[1]) {
            case "+": c = a + b;
                break;
            case "-": c = a - b;
                break;
            case "*": c = a * b;
        }

        System.out.println(line + c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 * 6 = ");
        }
    }
}

