package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(String s) {

    }

    public static void printMatrix(Object o) {

    }

    public static void printMatrix(int n, int m) {

    }

    public static void printMatrix(double a, double b) {

    }

    public static void printMatrix(String s, String o) {

    }

    public static void printMatrix(Object o1, Object o2) {}

    public static void printMatrix(int[] array) {}

    public static void printMatrix(List list) {}
}
