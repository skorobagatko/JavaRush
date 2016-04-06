package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;
        Solution s = (Solution) o;
        if (s.first != this.first) return false;
        if (s.last != this.last) return false;
        return true;
    }

    public int hashCode() {
        final int prime = 41;
        int result = 1;
        result = prime * result + (first == null ? 0 : first.hashCode()); // программа не проходила проверку, т.к. в этом методе небыло проверки полей на null
        result = prime * result + (last == null ? 0 : last.hashCode());
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
