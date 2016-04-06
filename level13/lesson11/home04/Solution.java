package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());

        List<String> listOfStrings = new ArrayList<String>();
        String string;

        while(true) {
            string = reader.readLine();
            if (string.equals("exit")) {
                listOfStrings.add(string);
                break;
            }

            listOfStrings.add(string);
        }

        FileWriter fileWriter = new FileWriter(file);
        for (String s : listOfStrings) {
            fileWriter.write(s + "\r\n");
        }

        fileWriter.close();
        reader.close();
    }
}
