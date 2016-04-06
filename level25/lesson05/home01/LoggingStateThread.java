package com.javarush.test.level25.lesson05.home01;

public class LoggingStateThread extends Thread {
    Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
        setDaemon(true);
    }

    public void run() {
        State currentState = target.getState();
        System.out.println(currentState);
        while(currentState != State.TERMINATED) {
            if (currentState != target.getState()) {
                currentState = target.getState();
                System.out.println(currentState.toString());
            }
        }
    }
}
