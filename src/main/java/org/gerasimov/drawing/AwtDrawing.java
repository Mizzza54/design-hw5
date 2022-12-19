package org.gerasimov.drawing;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Gerasimov
 */
public class AwtDrawing extends Frame implements DrawingApi {

    private static final List<Shape> shapes = new ArrayList<>();

    @Override
    public void drawCircle(Point c, int r) {
        shapes.add(new Ellipse2D.Double(c.getX() - r / 2.0, c.getY() - r / 2.0, r, r));
    }

    @Override
    public void drawLine(Point a, Point b) {
        shapes.add(new Line2D.Double(a.getX(), a.getY(), b.getX(), b.getY()));
    }

    @Override
    public void draw() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        setSize(DrawingApi.WIDTH, DrawingApi.HEIGHT);
        setVisible(true);
        setTitle("AWT");
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D ga = (Graphics2D) g;
        shapes.forEach(ga::draw);
    }
}