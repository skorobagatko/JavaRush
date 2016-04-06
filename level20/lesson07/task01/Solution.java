package com.javarush.test.level20.lesson07.task01;

import java.io.*;

/* Externalizable для апартаментов
Реализуйте интерфейс Externalizable для класса Apartment
Подумайте, какие поля не нужно сериализовать.
*/
public class Solution {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File tmpFile = File.createTempFile("externalizable", ".txt");
        OutputStream outputStream = new FileOutputStream(tmpFile);
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);

        Apartment apt = new Apartment("Lesnaya", 2000);
        System.out.println(apt);
        apt.writeExternal(oos);
        oos.close();
        outputStream.close();

        InputStream inputStream = new FileInputStream(tmpFile);
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        Apartment newApt = new Apartment();
        newApt.readExternal(ois);
        System.out.println(newApt);

        ois.close();
        inputStream.close();
    }

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address = (String) in.readObject();
            year = in.readInt();
        }
    }
}
