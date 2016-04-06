package com.javarush.test.level25.lesson16.big01;

public class Ufo extends BaseObject {
    private int count = 0;

    private static int[][] matrix = {
            {1, 1, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0},
    };

    public Ufo(double x, double y) {
        super(x, y, 3);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y, matrix, 'M');
    }

    @Override
    public void move() {
        double dx = Math.random() * 2 - 1;
        double dy = Math.random() * 2 - 1;
        x += dx;
        if (y + dy <= Space.game.height / 2 ) {
            y += dy;
        }
        if (++count == 10) {
            count = 0;
            fire();
        }
    }

    public void fire() {
        Bomb bomb = new Bomb(x, y);
        Space.game.getBombs().add(bomb);
    }
}
