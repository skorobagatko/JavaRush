package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        IncomeData incomeData = new IncomeData() {
            @Override
            public String getCountryCode() {
                return "UA";
            }

            @Override
            public String getCompany() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getContactFirstName() {
                return "Ivan";
            }

            @Override
            public String getContactLastName() {
                return "Ivanov";
            }

            @Override
            public int getCountryPhoneCode() {
                return 38;
            }

            @Override
            public int getPhoneNumber() {
                return 1234567;
            }
        };

        Customer customer = new IncomeDataAdapter(incomeData);
        Contact contact = new IncomeDataAdapter(incomeData);
        System.out.println(contact.getPhoneNumber());
        System.out.println(contact.getName());
        System.out.println(customer.getCompanyName());
        System.out.println(customer.getCountryName());
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData incomeData;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.incomeData = incomeData;
        }

        @Override
        public String getName() {
            return incomeData.getContactLastName() + ", " + incomeData.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String phone = String.valueOf(this.incomeData.getPhoneNumber());
            String code = String.valueOf(this.incomeData.getCountryPhoneCode());
            String result = "";
            if (phone.length() < 10) {
                String zeroes = "";
                for (int i = 0; i < 10-phone.length(); i++) {
                    zeroes+="0";
                }
                result = zeroes + phone;
            }

            return "+" + code + "(" + result.substring(0,3) + ")" + result.substring(3,6)+"-"+result.substring(6,8)+"-"+result.substring(8,10);
        }

        @Override
        public String getCompanyName() {
            return this.incomeData.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(this.incomeData.getCountryCode());
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}