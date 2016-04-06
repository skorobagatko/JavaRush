package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter {

    public FileConsoleWriter(String fileName) throws IOException {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        super(fileName, append);
    }


    @Override
    public void write(int c) throws IOException {
        super.write(c);
        System.out.println(c);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        super.write(cbuf, off, len);
        for (int i = off; i < len; i++) {
            System.out.println(cbuf[i]);
        }
    }

    @Override
    public void write(String str) throws IOException {
        super.write(str);
        System.out.println(str);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        super.write(str, off, len);
        System.out.println(str.substring(off, len));
    }
}
