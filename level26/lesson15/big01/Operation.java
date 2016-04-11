package com.javarush.test.level26.lesson15.big01;

public enum Operation {
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) {
        if (i < 1 || i > Operation.values().length) throw new IllegalArgumentException();
        Operation result = null;
        for (Operation o : Operation.values()) {
            if (o.ordinal() + 1 == i) result = o;
        }
        return result;
    }
}
