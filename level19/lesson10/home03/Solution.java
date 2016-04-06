package com.javarush.test.level19.lesson10.home03;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        String file = args[0];

        BufferedReader readFile = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String[] line;
        while (readFile.ready()) {
            line = readFile.readLine().split(" ");
            System.out.println(Arrays.toString(line));
            String name = "";
            Date bd;
            Calendar calendar;
            for (int index = 1; index < line.length; index++) {
                if (line[index].matches("\\d*")) {
                    for (int i = 0; i < index; i++) {
                        if (i == index-1) { name = name.concat(line[i]);  }   // убираем лишний пробел в конце имени
                        else { name = name.concat(line[i]).concat(" "); }
                    }
                    int year = Integer.parseInt(line[index+2]);
                    int month = Integer.parseInt(line[index+1]);
                    int day = Integer.parseInt(line[index]);
                    calendar = new GregorianCalendar(year, month-1, day);
                    bd = calendar.getTime();
                    PEOPLE.add(new Person(name, bd));
                    break;
                }
            }
        }
        readFile.close();

    }

}
