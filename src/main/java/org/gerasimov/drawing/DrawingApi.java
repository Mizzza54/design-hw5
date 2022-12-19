package org.gerasimov.drawing;

public interface DrawingApi {
    int WIDTH = 600;
    int HEIGHT = 400;

    default int getDrawingAreaWidth() {
        return WIDTH;
    }

    default int getDrawingAreaHeight() {
        return HEIGHT;
    }

    void drawCircle(Point c, int r);

    void drawLine(Point a, Point b);

    void draw();
}