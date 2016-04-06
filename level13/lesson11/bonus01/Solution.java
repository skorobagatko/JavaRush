package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader readFileName = new BufferedReader(new InputStreamReader(System.in));
        File fileName = new File(readFileName.readLine());
        BufferedReader readFile = new BufferedReader(new FileReader(fileName));

        List<String> list = new ArrayList<String>();

        String num;
        while((num = readFile.readLine()) != null) {

            list.add(num);
        }

        int[] numArray = new int[list.size()];
        for(int index = 0; index < list.size(); index++) {
            numArray[index] = Integer.parseInt(list.get(index));
        }

        Arrays.sort(numArray);

        for(int i : numArray) {
            if (i % 2 == 0)
            {
                System.out.println(i);
            }
        }

        readFile.close();
        readFileName.close();

    }
}
