package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
        int a = 1;
        print(a);
        Integer b = 2;
        print(b);
    }

    //Напишите тут ваши методы
    public static void print(int i) {
        System.out.println(i);
        System.out.println("int");
    }

    public static void print(Integer i) {
        System.out.println(i);
        System.out.println("Integer");
    }
}
