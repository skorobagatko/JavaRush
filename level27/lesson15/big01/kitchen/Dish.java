package com.javarush.test.level27.lesson15.big01.kitchen;

public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString() {
        StringBuilder result = new StringBuilder("");
        for (Dish dish : Dish.values()) {
            result.append(dish.toString()).append(", ");
        }
        result.delete(result.length()-2, result.length());
        return result.toString();
    }
}
