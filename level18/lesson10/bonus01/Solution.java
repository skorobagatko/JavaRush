package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String fileName = args[1];
        String fileOutputName = args[2];

        BufferedInputStream is = new BufferedInputStream(new FileInputStream(fileName));
        byte[] buffer = new byte[is.available()];
        int count = is.read(buffer);
        is.close();
        byte[] cryptedArray = new byte[buffer.length];
        if (args[0].equals("-e")) {
            cryptedArray = encrypt(buffer);
        } else if (args[0].equals("-d")) {
            cryptedArray = decrypt(buffer);
        }
        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(fileOutputName));
        os.write(cryptedArray);
        os.close();

    }
    // зашифровать байты из файла и вернуть результат
    public static byte[] encrypt(byte[] array) {
        byte[] encryptedArray = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            encryptedArray[i] = (byte) (array[i] + 1);
        }
        return encryptedArray;
    }
    // расшифровать данные из файла и вернуть результат
    public static byte[] decrypt(byte[] array) {
        byte[] decryptedArray = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            decryptedArray[i] = (byte) (array[i] - 1);
        }
        return decryptedArray;
    }

}
