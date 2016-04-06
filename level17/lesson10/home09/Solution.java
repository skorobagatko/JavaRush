package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            FileReader fileLines = new FileReader(reader.readLine());
            FileReader fileRemoveLines = new FileReader(reader.readLine());
            reader.close();

            BufferedReader readLinesFromFile = new BufferedReader(fileLines);
            String line = null;
            while ((line = readLinesFromFile.readLine()) != null) {
                allLines.add(line);
            }
            readLinesFromFile.close();

            readLinesFromFile = new BufferedReader(fileRemoveLines);
            line = null;
            while ((line = readLinesFromFile.readLine()) != null) {
                forRemoveLines.add(line);
            }
            readLinesFromFile.close();

            new Solution().joinData();


        } catch (CorruptedDataException e) { e.printStackTrace(); }
         catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            for (int index = 0; index < allLines.size(); ) {
                if (forRemoveLines.contains(allLines.get(index))) {
                    allLines.remove(index);
                } else { index++; }
            }
        }

        int count = 0;
        for (String line : forRemoveLines) {
            if (allLines.contains(line)) { count++; }
        }
        if (count == 0) {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
