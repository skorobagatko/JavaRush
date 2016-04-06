package com.javarush.test.level25.lesson09.task03;

public class Test {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                throw new RuntimeException("RE", new IllegalArgumentException("IAE", new NullPointerException("NPE")));
            }
        });

        t.setUncaughtExceptionHandler(new Solution());
        t.start();
    }
}
