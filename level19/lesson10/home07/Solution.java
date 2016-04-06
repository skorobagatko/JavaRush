package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
//        String file1 = "e:/a.txt";
//        String file2 = "e:/b.txt";
        String file1 = args[0];
        String file2 = args[1];

        BufferedReader readFile = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));
        BufferedWriter writeFile = new BufferedWriter(new FileWriter(file2));
        String[] lines;
        StringBuilder lineForWrite = new StringBuilder("");
        while (readFile.ready()) {
            lines = readFile.readLine().split(" ");
            System.out.println(Arrays.toString(lines));

            for (String s : lines) {
                if (s.length()>6) {
                    lineForWrite.append(s).append(",");
                }
            }
        }
        String result = lineForWrite.toString();
        writeFile.write(result.substring(0,result.length()-1));
        writeFile.close();
        readFile.close();
    }
}
