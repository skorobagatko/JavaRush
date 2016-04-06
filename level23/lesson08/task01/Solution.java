package com.javarush.test.level23.lesson08.task01;

/* Напряги извилины!
Метод printName должен выводить свое собственное имя, т.е. "sout"
Сделайте минимум изменений.
*/
public class Solution {
    private String name;

    Solution(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    /*  Вся проблема была вот в чем: методы, помеченные как private не наследуются, поэтому в нашем анонимном классе его не будет,
        но, т.к. мы находимся внутри внешнего класса-родителся, мы все-таки можем его вызвать и он таки вызывается
        и возвращает нам имя объекта внешнего класса-родителя (main) а не нашего объекта анонимного класса.
    */
    private void sout() {
        new Solution("sout") {
            void printName() {
                System.out.println(getName());
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Solution("main").sout();
    }
}
