package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File file = File.createTempFile("JavaRush", ".txt");
            OutputStream outputStream = new FileOutputStream(file);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user = new User();
            user.setFirstName("Vasya");
            user.setLastName("Vasilenko");
            user.setMale(true);
            user.setBirthDate(new Date());
            user.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user);

            javaRush.save(outputStream);
            outputStream.flush();
            outputStream.close();

            JavaRush loadedObject = new JavaRush();
            InputStream inputStream = new FileInputStream(file);
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            for (User u: loadedObject.users) {
                System.out.println(u.getFirstName());
                System.out.println(u.getLastName());
                System.out.println(u.getBirthDate());
                System.out.println(u.isMale());
                System.out.println(u.getCountry());
            }


            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
//            if (this.users.isEmpty()) {
//                printWriter.close();
//                return;
//            }
            for (User user : this.users) {
                String firstName = user.getFirstName();
                String lastName = user.getLastName();
                String birthDate = user.getBirthDate().toString();
                String isMale = String.valueOf(user.isMale());
                String country = user.getCountry().getDisplayedName();
                printWriter.println(firstName + "," + lastName + "," + birthDate + "," + isMale + "," + country);
            }
            printWriter.println("end");
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            if (this.users.isEmpty()) {
//                reader.close();
//                return;
//            }

            String s;
            while (!(s = reader.readLine()).equals("end")) {
                String[] userFields = s.split(",");
//                System.out.println(Arrays.toString(userFields));
                String firstName = userFields[0];
                String lastName = userFields[1];
                Date birthDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH).parse(userFields[2]);
                boolean isMale = Boolean.parseBoolean(userFields[3]);
                User.Country country = User.Country.valueOf(userFields[4].toUpperCase());
//
                User user = new User();
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setBirthDate(birthDate);
                user.setMale(isMale);
                user.setCountry(country);
                this.users.add(user);
            }
            reader.close();
        }
    }
}
