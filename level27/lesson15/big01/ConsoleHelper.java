package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> result = new ArrayList<>();
        writeMessage("Please, choose the dish.\n" + Dish.allDishesToString());
        String input;
        while (!(input = readString()).equals("exit")) {
            for (Dish dish : Dish.values()) {
                if (input.equals(dish.toString())) {
                    result.add(dish);
                }
            }
        }

        return result;
    }
}
