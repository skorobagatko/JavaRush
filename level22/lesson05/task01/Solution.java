package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush -  лучший сервис обучения Java."));
    }

    // Долго не мог решить задачу, т.к. не учел, что пробелы могут идти подряд и это нужно учитывать, нужно считать общее кол-во пробелов.

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();
        if (!string.contains(" ")) throw new TooShortStringException();
        int firstSpace = string.indexOf(" ");                                       // индекс первого пробела
        int lastSpace = string.indexOf(" ", firstSpace+1);                           // второй пробел, начинаем проверку с позиции сразу после первого пробела
        if (lastSpace == -1) throw new TooShortStringException();
        lastSpace = string.indexOf(" ", lastSpace+1);                               // третий пробел
        if (lastSpace == -1) throw new TooShortStringException();
        lastSpace = string.indexOf(" ", lastSpace+1);                               // четвертый пробел
        if (lastSpace == -1) throw new TooShortStringException();
        String afterLastSpace = string.substring(lastSpace+1, string.length());     // выделяем из оригинальной строки подстроку после четвертого пробела и до конца ориг. строки
        if (afterLastSpace.length() == 0) throw new TooShortStringException();
        char[] afterLastSpaceArray = afterLastSpace.toCharArray();                  // переводи строку в массив символов и проверяем символы на то, что это буквы
        int lastIndex = 0;
        for (int index = 0; index < afterLastSpaceArray.length; index++) {
            if (!Character.isLetter(afterLastSpaceArray[index])) break;             // если символ - не буква - выходим из цикла, дальше идти не нужно, нам нужно только одно слово после 4-го пробела
            lastIndex = index;
        }

        return string.substring(firstSpace+1, lastSpace + 2 + lastIndex);
    }

    public static class TooShortStringException extends Exception {
    }
}
