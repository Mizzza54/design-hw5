package org.gerasimov.graph;

import org.gerasimov.drawing.DrawingApi;
import org.gerasimov.drawing.Point;

public abstract class Graph {
    private static final int MARGIN = 42;
    private final DrawingApi drawingApi;

    public Graph(DrawingApi drawingApi) {
        this.drawingApi = drawingApi;
    }

    public abstract void drawGraph();

    public abstract int size();

    public void drawVertex(int i) {
        drawingApi.drawCircle(getVertexPosition(i), 15);
    }

    public void drawEdge(int a, int b) {
        drawingApi.drawLine(getVertexPosition(a), getVertexPosition(b));
    }

    private Point getVertexPosition(int i) {
        double t = 2 * Math.PI * i / size();
        int x = mapTrigToBoundWithMargin(Math.sin(t), drawingApi.getDrawingAreaWidth());
        int y = mapTrigToBoundWithMargin(Math.cos(t), drawingApi.getDrawingAreaHeight());
        return new Point(x, y);
    }

    private int mapTrigToBoundWithMargin(double trig, int bound) {
        return (int) map(trig, bound - Graph.MARGIN);
    }

    private double map(double value, double outEnd) {
        return (value - (double) -1) / ((double) 1 - (double) -1) * (outEnd - (double) Graph.MARGIN) + (double) Graph.MARGIN;
    }

    public DrawingApi getDrawingApi() {
        return drawingApi;
    }
}

