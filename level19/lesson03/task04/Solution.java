package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("e:/a.txt"));
        PersonScanner scannerAdapter = new PersonScannerAdapter(scanner);
        Person person = scannerAdapter.read();
        System.out.println(person);
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String firstName = "";
            String lastName = "";
            String middleName = "";
            Date birthDate = null;

            String[] lines = this.scanner.nextLine().split(" ");
            lastName = lines[0];
            firstName = lines[1];
            middleName = lines[2];
            Calendar calendar = new GregorianCalendar(Integer.parseInt(lines[5]), Integer.parseInt(lines[4])-1, Integer.parseInt(lines[3]));
            birthDate = calendar.getTime();
            return new Person(firstName, middleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException {
            this.scanner.close();
        }
    }
}
