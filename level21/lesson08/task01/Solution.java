package com.javarush.test.level21.lesson08.task01;

import java.util.LinkedHashMap;
import java.util.Map;

/* Глубокое клонирование карты
Клонируйтие объект класса Solution используя глубокое клонирование.
Данные в карте users также должны клонироваться.
Метод main изменять нельзя.
*/
public class Solution implements Cloneable {

    protected Map<String, User> users = new LinkedHashMap();

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }
    // Проблема была в том, что в методе main не выбрасывалось исключение CloneNotSupportedException и
    // компилятор не пропускал код. При этом, нельзя было менять метод main.
    // Решение - указать в сигнатуре метода clone() что он выбрасывает исключение CloneNotSupportedException
    public Solution clone() throws CloneNotSupportedException {
        Solution solution = new Solution();
        for (Map.Entry<String, User> elem : this.users.entrySet()) {
            String s = new String(elem.getKey());
            User user = elem.getValue().clone();
            solution.users.put(s, user);
        }
        return solution;
    }

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public User clone() {
            String name = new String(this.name);
            return new User(this.age, name);
        }
    }
}
