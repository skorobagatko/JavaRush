package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        String file1 = "e:/a.txt";
//        String file2 = "e:/b.txt";
        String file1 = args[0];
        String file2 = args[1];

        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2));
        String[] lines;
        StringBuilder stringBuilder = new StringBuilder("");;
        while (fileReader.ready()) {
            lines = fileReader.readLine().split(" ");
            for (int index = 0; index < lines.length; index++) {
                if (lines[index].matches("[a-zA-Z]+\\d+|\\d+[a-zA-Z]+|.+\\d+.+")) {
                    System.out.println(lines[index]);
                    stringBuilder.append(lines[index] + " ");
                }
            }

        }
        String result = stringBuilder.toString();
        result = result.substring(0, result.length()-1);
        fileWriter.write(result);

        fileWriter.close();
        fileReader.close();
    }
}
