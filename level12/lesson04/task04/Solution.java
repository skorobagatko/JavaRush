package com.javarush.test.level12.lesson04.task04;

/* Три метода возвращают минимальное из двух переданных в него чисел
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(min(1,2));
        System.out.println(min(10L, 20L));
        System.out.println(min(1.0, 2.0));
    }

    //Напишите тут ваши методы
    public static int min(int i, int j) {
        int min;
        return (min = ( i < j ) ? i : j );
    }

    public static long min( long l, long m ) {
        long min;
        return (min = ( l < m ) ? l : m );
    }

    public static double min( double d, double e ) {
        double min;
        return (min = ( d < e ) ? d : e );
    }
}
