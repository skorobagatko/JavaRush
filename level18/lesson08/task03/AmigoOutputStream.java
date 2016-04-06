package com.javarush.test.level18.lesson08.task03;

import java.io.*;
import java.nio.channels.FileChannel;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используйте наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream fileOutputStream;

    public void write(int b) throws IOException
    {
        fileOutputStream.write(b);
    }

    public void write(byte[] b) throws IOException
    {
        fileOutputStream.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException
    {
        fileOutputStream.write(b, off, len);
    }

    public void close() throws IOException
    {
        fileOutputStream.flush();
        String copyright = "JavaRush © 2012-2013 All rights reserved.";
        fileOutputStream.write(copyright.getBytes());
        fileOutputStream.close();
    }

    public FileChannel getChannel()
    {
        return fileOutputStream.getChannel();
    }

    public void flush() throws IOException
    {
        fileOutputStream.flush();
    }

    public AmigoOutputStream(FileOutputStream fileOutputStream)
    {
        this.fileOutputStream = fileOutputStream;
    }


    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
