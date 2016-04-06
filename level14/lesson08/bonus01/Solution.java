package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (ArithmeticException e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try {
            int[] array = new int[10];
            array[10] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            String s = null;
            s.charAt(1);
        } catch (NullPointerException e) {
            exceptions.add(e);
        }

        try {
            int[] arr = new int[-1];
        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }

        try {
            Object i = new Integer(1);
            String s = (String) i;
        } catch (ClassCastException e) {
            exceptions.add(e);
        }

        try {
            Object[] array = new Integer[10];
            array[0] = "";
        } catch (ArrayStoreException e) {
            exceptions.add(e);
        }

        try {
            Object o = "r";
            int i = Integer.parseInt((String)o);
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }

        try {
            FileInputStream is = new FileInputStream("z:/a.txt");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String s = "123";
            char ch = s.charAt(100);
        } catch (StringIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            List<String> list = new ArrayList<String>();
            list.get(1);
        } catch (IndexOutOfBoundsException e) {
            exceptions.add(e);
        }

    }
}
