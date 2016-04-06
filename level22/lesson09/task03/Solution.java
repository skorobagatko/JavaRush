package com.javarush.test.level22.lesson09.task03;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "windows-1251"));
        StringBuilder sb = new StringBuilder("");
        while (fileReader.ready()) {
            sb.append(fileReader.readLine()).append(" ");
        }
        fileReader.close();

        String[] words = sb.toString().trim().split(" ");

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder();
        if (words==null || words.length==0) return result;
        if (words.length==1) {
            result.append(words[0]);
            return result;
        }

        ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
        Collections.shuffle(list);

        Set<String> set = new HashSet<String>(); // будем проверять повторение слов по их наличию в сете
        String s1 = list.get(0);                   // присваиваем начальное значение, первое слово из массива
        while (set.size() != list.size()) {    // цикл работает, пока в сет не будут добавлены все слова из массива
            set.add(s1);                        // что в свою очередь, значит, что мы прошлись по всем словам из массива
            result.append(s1).append(" ");
            for (String s2 : list) {
                if (!set.contains(s2)) {
                    char ch1 = s1.toLowerCase().charAt(s1.length()-1);
                    char ch2 = s2.toLowerCase().charAt(0);
                    if (ch1==ch2) {
                        s1 = s2;
                        break;
                    }
                }
            }
        }
        result = new StringBuilder(result.toString().trim());  // убираем лишний пробел в конце строки
        return result;                          // результат соответствует требованию задания
    }
}
