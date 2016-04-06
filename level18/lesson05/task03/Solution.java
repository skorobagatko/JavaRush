package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream os1 = new FileOutputStream(reader.readLine());
        FileOutputStream os2 = new FileOutputStream(reader.readLine());

        byte[] buffer1;
        if (inputStream.available() % 2 == 0) {
            buffer1 = new byte[inputStream.available() / 2];
        }  else {
            buffer1 = new byte[(inputStream.available()/2)+1];
        }
            int count1 = inputStream.read(buffer1);
            os1.write(buffer1);
            byte[] buffer2 = new byte[inputStream.available()];
            int count2 = inputStream.read(buffer2);
            os2.write(buffer2);

        os2.close();
        os1.close();
        inputStream.close();
        reader.close();
    }
}
