package com.javarush.test.level12.lesson04.task05;

/* Три метода возвращают максимальное из двух переданных в него чисел
Написать public static методы: int max(int, int), long max (long, long), double max (double, double).
Каждый метод должен возвращать максимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    //Напишите тут ваши методы

    public static int max(int i , int j) {
        int max;
        return (max = (i > j) ? i : j);
    }

    public static long max(long l, long m) {
        long max;
        return (max = (l > m) ? l : m);
    }

    public static double max(double d, double e) {
        double max;
        return (max = (d > e) ? d : e);
    }
}
