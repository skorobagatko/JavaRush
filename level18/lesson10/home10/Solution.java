package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedInputStream is = null;
        String fileName = "";
        String extension = "";
        String checkNameOfFile = null;
        int filePartNumber = 0;
        Map<Integer, byte[]> mapOfByteArrays = new HashMap<>();
        File fileForWrite = null;

        while (!(fileName = reader.readLine()).equals("end")) {
            if (checkNameOfFile==null) {
                checkNameOfFile = fileName.substring(fileName.lastIndexOf(":")+2, fileName.lastIndexOf("."));
                fileForWrite = new File(fileName.substring(0, fileName.lastIndexOf(".")));
            }

            extension = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
            if (fileName.contains(checkNameOfFile + "." + extension)) {
                filePartNumber = Integer.parseInt(extension.substring(extension.lastIndexOf("t")+1, extension.length()));
                is = new BufferedInputStream(new FileInputStream(fileName));
                byte[] buffer = new byte[is.available()];
                int count = is.read(buffer);
                is.close();
                mapOfByteArrays.put(filePartNumber, buffer);
            }
        }
        reader.close();

        Map<Integer, byte[]> sortedMap = new TreeMap<>(mapOfByteArrays);

        if (!fileForWrite.exists()) { fileForWrite.createNewFile(); }

        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(fileForWrite));
        for (Map.Entry<Integer, byte[]> pair : sortedMap.entrySet()) {
            os.write(pair.getValue());
        }
        os.close();
    }
}
