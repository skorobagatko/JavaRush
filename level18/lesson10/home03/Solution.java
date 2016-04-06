package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream os1 = new FileOutputStream(reader.readLine());
        FileInputStream is2 = new FileInputStream(reader.readLine());
        FileInputStream is3 = new FileInputStream(reader.readLine());

        if (is2.available() > 0) {
            byte[] bytes = new byte[is2.available()];
            int count = is2.read(bytes);
            os1.write(bytes);
        }

        if (is3.available() > 0) {
            byte[] bytes = new byte[is3.available()];
            int count = is3.read(bytes);
            os1.write(bytes);
        }

        is3.close();
        is2.close();
        os1.close();
        reader.close();
    }
}
