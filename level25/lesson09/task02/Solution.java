package com.javarush.test.level25.lesson09.task02;

import java.util.TimerTask;

/* Вооружаемся до зубов!
Создайте свой UncaughtExceptionHandler в виде локального класса внутри конструктора.
UncaughtExceptionHandler должен маскать звездочками имя трэда.
"Thread-0" должно быть заменено на "********"
"Thread-4321" должно быть заменено на "***********"
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                int nameLength = t.getName().length();
                StringBuilder sb = new StringBuilder("");
                for (int i = 0; i < nameLength; i++) {
                    sb.append("*");
                }
                String newName = sb.toString();
                System.out.println(e.getMessage().replace(t.getName(), newName));
            }
        };
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        new Thread(new Solution(new TimerTask() {
            @Override
            public void run() {
                int x = 0;
                int y = 1;
                int z = y/x;
            }
        })).start();
    }
}