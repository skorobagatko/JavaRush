package com.javarush.test.level21.lesson08.task02;

/* Клонирование
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
Метод main изменять нельзя.
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        public Tree clone() throws CloneNotSupportedException {
            Tree tree = (Tree) super.clone();
//            String name = this.getName() == null ? null : new String(this.getName());
            String[] branches = this.getBranches() == null ? null : new String[this.getBranches().length];
            if (branches != null) {
                for (int i = 0; i < this.getBranches().length; i++) {
                    branches[i] = this.getBranches()[i];
                }
            }      //  программа не проходила тестирование, т.к. отстутствовала проверка массива на null пере выполнением копирования
            tree.branches = branches;
            return tree;
        }
    }
}
