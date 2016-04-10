package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        int count = 1;
        try {
            while (!currentThread.isInterrupted()) {
                map.put(String.valueOf(count), "Some text for " + String.valueOf(count++));
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(currentThread.getName() + " thread was terminated");
        }
    }
}
