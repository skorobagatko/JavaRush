package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File file = File.createTempFile("human", ".txt");
            OutputStream outputStream = new FileOutputStream(file);
            InputStream inputStream = new FileInputStream(file);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            outputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(somePerson.name);
            for (Asset asset : somePerson.assets) {
                System.out.println(asset.getName());
            }

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);

            writer.println(this.name);
            if (this.assets.isEmpty()) {
                writer.println("no assets");
                writer.close();
            } else {
                writer.println("assets");
                for (Asset asset : this.assets) {
                    writer.println(asset.getName() + " " + asset.getPrice());
                }
                writer.println("end");

                writer.close();
            }

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            this.name = reader.readLine();
            String s;
            if ((s = reader.readLine()).equals("no assets")) {
                reader.close();
                System.out.println("no assets");
                return;
            } else {
                while (!(s = reader.readLine()).equals("end")) {
                    String[] assets = s.split(" ");
                    Asset asset = new Asset(assets[0]);
                    asset.setPrice(Double.parseDouble(assets[1]));
                    this.assets.add(asset);
                }
                reader.close();
            }
        }
    }
}
