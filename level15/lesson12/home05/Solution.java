package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    private Solution(float f) {}
    private Solution(String s) {}
    private Solution(int i) {}

    Solution(String s, String i) {}
    Solution(int i, int j) {}
    Solution(double d) {}

    protected Solution(double d, double t) {}
    protected Solution(float f, float t) {}
    protected Solution(Object o) {}

    public Solution(int[] array) {}
    public Solution(String[] array) {}
    public Solution(char[] ch) {}
}

