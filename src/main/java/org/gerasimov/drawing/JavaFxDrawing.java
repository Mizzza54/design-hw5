package org.gerasimov.drawing;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Gerasimov
 */
public class JavaFxDrawing implements DrawingApi {

    private static final List<Shape> shapes = new ArrayList<>();

    @Override
    public void drawCircle(Point c, int r) {
        shapes.add(new Circle(c.getX(), c.getY(), r));
    }

    @Override
    public void drawLine(Point a, Point b) {
        shapes.add(new Line(a.getX(), a.getY(), b.getX(), b.getY()));
    }

    @Override
    public void draw() {
        Application.launch(DrawingJavaFxApplication.class);
    }

    public static class DrawingJavaFxApplication extends Application {

        @Override
        public void start(Stage stage) {
            Group root = new Group();
            shapes.forEach(root.getChildren()::add);
            stage.setScene(new Scene(root, WIDTH, HEIGHT));
            stage.show();
            stage.setTitle("JavaFX");
        }
    }
}
