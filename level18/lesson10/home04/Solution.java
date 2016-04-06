package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
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
        FileInputStream is1 = new FileInputStream(file1);
        FileInputStream is2 = new FileInputStream(file2);

        byte[] buffer2 = new byte[is2.available()];
        int count1 = is2.read(buffer2);
        is2.close();

        byte[] buffer1 = new byte[is1.available()];
        int count2 = is1.read(buffer1);
        is1.close();

        byte[] sum = new byte[buffer1.length + buffer2.length];
        System.arraycopy(buffer2,0,sum,0,buffer2.length);
        System.arraycopy(buffer1,0,sum,buffer2.length,buffer1.length);

        FileOutputStream os1 = new FileOutputStream(file1);
        os1.write(sum);

        os1.close();
    }
}
