package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome {

    public static Hippodrome game;

    ArrayList<Horse> horses = new ArrayList<Horse>();

    public static void main(String[] args) {

        game = new Hippodrome();
        Horse horse1 = new Horse("horse1", 3, 0);
        Horse horse2 = new Horse("horse2", 3, 0);
        Horse horse3 = new Horse("horse3", 3, 0);

        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();
        game.printWinner();
    }

    public ArrayList<Horse> getHorses() {
        return this.horses;
    }

    public Horse getWinner() {
        double maxDistance = 0.0;
        Horse h = null;
        for (Horse horse : horses) {
            if (horse.getDistance() > maxDistance) {
                maxDistance = horse.getDistance();
                h = horse;
            }
        }
        return h;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for( Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for(Horse horse : horses) {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

}
