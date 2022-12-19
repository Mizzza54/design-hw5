package org.gerasimov.drawing;

/**
 * @author Michael Gerasimov
 */
public class Point {
    private final int x;
    private final int y;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}