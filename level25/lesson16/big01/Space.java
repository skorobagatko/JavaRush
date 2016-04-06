package com.javarush.test.level25.lesson16.big01;

import java.util.ArrayList;

public class Space {
    int width;
    int height;
    SpaceShip ship;
    ArrayList<Ufo> ufos = new ArrayList<Ufo>();
    ArrayList<Rocket> rockets = new ArrayList<Rocket>();
    ArrayList<Bomb> bombs = new ArrayList<Bomb>();

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void run() {

    }

    public void draw() {

    }

    public void sleep(int ms) {

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public SpaceShip getShip() {
        return ship;
    }

    public void setShip(SpaceShip ship) {
        this.ship = ship;
    }

    public ArrayList<Ufo> getUfos() {
        return ufos;
    }

    public ArrayList<Rocket> getRockets() {
        return rockets;
    }

    public ArrayList<Bomb> getBombs() {
        return bombs;
    }

    public static void main(String[] args) {

    }
}
