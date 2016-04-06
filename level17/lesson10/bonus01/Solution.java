package com.javarush.test.level17.lesson10.bonus01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
//        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//        System.out.println(format.format(allPeople.get(0).getBirthDay()));

        String name;

        if (args.length > 2) {
            if (args[0].equals("-c")) {
                name = args[1];
                if (!args[2].equals("м") && !args[2].equals("ж")) {
                    name += " " + args[2];
                    if (args[3].equals("м")) {
                        allPeople.add(Person.createMale(name, new Date(args[4])));
                    } else if (args[3].equals("ж")) {
                        allPeople.add(Person.createFemale(name, new Date(args[4])));
                    }
                } else {
                    if (args[2].equals("м")) {
                        allPeople.add(Person.createMale(name, new Date(args[3])));
                    } else if (args[2].equals("ж")) {
                        allPeople.add(Person.createFemale(name, new Date(args[3])));
                    }
                }
            } else if (args[0].equals("-u")) {
                int id = Integer.parseInt(args[1]);
                name = args[2];
                if (!args[3].equals("м") && !args[3].equals("ж")) {
                    name += " " + args[3];
                    allPeople.get(id).setName(name);
                    allPeople.get(id).setBirthDay(new Date(args[5]));
                    if (args[4].equals("м")) {
                        allPeople.get(id).setSex(Sex.MALE);
                    } else if (args[4].equals("ж")) {
                        allPeople.get(id).setSex(Sex.FEMALE);
                    }
                } else {
                    allPeople.get(id).setName(name);
                    allPeople.get(id).setBirthDay(new Date(args[4]));
                    if (args[3].equals("м")) {
                        allPeople.get(id).setSex(Sex.MALE);
                    } else if (args[3].equals("ж")) {
                        allPeople.get(id).setSex(Sex.FEMALE);
                    }
                }

            }
        } else if (args.length == 2) {
            int id = Integer.parseInt(args[1]);
            if (args[0].equals("-d")) {
                allPeople.remove(id);
            } else if (args[0].equals("-i")) {
                String sex = "";
                Date date = allPeople.get(id).getBirthDay();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                name = allPeople.get(id).getName();
                if (allPeople.get(id).getSex().equals(Sex.MALE)) { sex = "м"; }
                else if (allPeople.get(id).getSex().equals(Sex.FEMALE)) { sex = "ж"; }
                System.out.println(name + " " + sex + " " + dateFormat.format(date));
            }
        }
    }
}
