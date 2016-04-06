package com.javarush.test.level21.lesson05.task03;

import java.util.Date;

/* Ошибка в equals/hashCode
Исправьте ошибки реализаций методов equals и hashCode для класса Solution
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Solution)) return false;

        Solution solution1 = (Solution) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        if (date != null ? !date.equals(solution1.date) : solution1.date == null) return false;
        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution == null) return false;
        if (string != null ? !string.equals(solution1.string) : solution1.string == null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + anInt;
        result = 31 * result + (string == null ? 0 : string.hashCode());
        long doubleToLong = Double.doubleToLongBits(aDouble);
        result = 31 * result + (int)(doubleToLong >>> 32);
        result = 31 * result + (date == null ? 0 : date.hashCode());
        result = 31 * result + (solution == null ? 0 : solution.hashCode());
        return result;
    }
}
