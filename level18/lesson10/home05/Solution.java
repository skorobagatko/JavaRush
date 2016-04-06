package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader file1Reader = new BufferedReader(new FileReader(file1));
        String s = "";
        while (file1Reader.ready()) {
            s = file1Reader.readLine();
        }
        file1Reader.close();

        String[] stringArray = s.split(" ");
        double[] doubleArray = new double[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringArray[i]);
        }

        BufferedWriter file2Writer = new BufferedWriter(new FileWriter(file2));
        for (Double d : doubleArray) {
            file2Writer.write(Integer.toString((int)Math.round(d)));
            file2Writer.write(" ");
        }
        file2Writer.close();
    }
}
