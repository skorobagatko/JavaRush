package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = "";
        ReadThread thread;
        while (!(file = reader.readLine()).equals("exit")) {
            thread = new ReadThread(file);
            thread.start();
            thread.join();
            thread.interrupt();
        }

        reader.close();
    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            Map<Integer, Integer> fileMap = new HashMap<Integer, Integer>();
            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(this.fileName);
                int bytes = 0;
                while (inputStream.available() > 0) {
                    bytes = inputStream.read();
                    if (fileMap.containsKey(bytes)) { fileMap.put(bytes, fileMap.get(bytes)+1); }
                    else { fileMap.put(bytes, 1); }
                }

                int maxValue = 0;
                for (Map.Entry<Integer, Integer> pair : fileMap.entrySet()) {
                    if (pair.getValue() > maxValue) { maxValue = pair.getValue(); }
                }

                synchronized (resultMap) {
                    for (Map.Entry<Integer, Integer> pair : fileMap.entrySet()) {
                        if (pair.getValue() == maxValue) {
                            resultMap.put(this.fileName, pair.getKey());
                        }
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("File Not Found!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
