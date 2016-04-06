package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        String file1 = args[0];
        String file2 = args[1];
//        String file1 = "e:/a.txt";
//        String file2 = "e:/b.txt";

        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        InputStream inputStream = new FileInputStream(file1);
        OutputStream outputStream = new FileOutputStream(file2);
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);               // Не мог пройти задачу без помощи, текст в файле-источнике изменялся на нормальный, а в файле-приемнике записывались каракули
        String s = new String(buffer, utf8);    // Оказалось что в этой строке кода, при создании строки, в конструкторе мы указываем источник данных для строки
        buffer = s.getBytes(windows1251);       // и кодировку В КОТОРОЙ нужно сохранить строку, а НЕ кодировку, в которой у нас записаны байты в массиве!
        outputStream.write(buffer);
        inputStream.close();
        outputStream.close();
    }
}
