package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

//    public static void main(String[] args) throws Exception {
//        Solution sol = new Solution();
//        sol.fillInPropertiesMap();
//
//        System.out.println(properties);
//        OutputStream outputStream = new FileOutputStream("e:/a.properties");
//        sol.save(outputStream);
//        outputStream.close();
//    }

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String propertiesFile = reader.readLine();
            reader.close();

            InputStream inputStream = new FileInputStream(propertiesFile);

            load(inputStream);
            inputStream.close();

        } catch (IOException e) {
            System.out.println("IOException");
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        Properties prop = new Properties();

        for (Map.Entry<String, String> pair : properties.entrySet()) {
            prop.put(pair.getKey(), pair.getValue());
        }

        prop.store(writer, "bla-bla-bla");
        writer.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод

        Properties prop = new Properties();
        prop.load(inputStream);
        for (Map.Entry<Object, Object> elem : prop.entrySet()) {
            String key = String.valueOf(elem.getKey());
            String value = String.valueOf(elem.getValue());
            properties.put(key, value);
        }
    }
}
