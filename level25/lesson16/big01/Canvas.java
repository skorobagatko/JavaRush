package com.javarush.test.level25.lesson16.big01;

public class Canvas {
    int width;
    int height;
    char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height][width];
    }

    public void setPoint(double x, double y, char c) {
        int roundedX = (int) x;
        int roundedY = (int) y;
        if (roundedX > 0 && roundedY > 0 && roundedX < matrix[0].length && roundedY < matrix.length) {
            matrix[roundedY][roundedX] = c;
        }
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c) {

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }
}
