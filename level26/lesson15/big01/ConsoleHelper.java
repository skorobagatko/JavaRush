package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String result = null;
        try {
            result = reader.readLine();
            if (result.equalsIgnoreCase("EXIT")) throw new InterruptOperationException();
        } catch (IOException ignore) { /*NOP*/ }
        return result;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        System.out.println("Please, enter the currency code.");
        String result = "";
        while (!(result = readString()).matches("^[a-zA-Z]{3}$")) {
            System.out.println("Currency code must have 3 symbols.\nPlease, try again.");
        }
        return result.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        System.out.println("Please, enter two positive integers separated by a space.");
        String[] result = null;
        String s;
        while (!(s = readString()).matches("^\\d+ \\d+$")) {
            System.out.println("Need enter two positive integers separated by a space. Please, try again.");
        }
        result = s.split(" ");
        return result;
    }

    public static Operation askOperation() throws InterruptOperationException {
        System.out.println("Please, choose operation that you want to do:"
                            + "\n1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
        Operation result = null;
        int input = Integer.valueOf(readString());
        while (result == null) {
            try {
                result = Operation.getAllowableOperationByOrdinal(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Please, choose operation that you want to do:"
                        + "\n1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
            }
        }
        return result;
    }
}
