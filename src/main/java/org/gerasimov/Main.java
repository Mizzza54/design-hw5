package org.gerasimov;

import org.gerasimov.drawing.AwtDrawing;
import org.gerasimov.drawing.DrawingApi;
import org.gerasimov.drawing.JavaFxDrawing;
import org.gerasimov.graph.Graph;
import org.gerasimov.graph.ListGraph;
import org.gerasimov.graph.MatrixGraph;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author Michael Gerasimov
 */
public class Main {
    public static void main(String[] args) throws IOException {
        if (args == null || args.length != 3 || Arrays.stream(args).anyMatch(Objects::isNull)) {
            System.out.println("Usage: [javafx or awt>] [list or matrix] [path to graph]");
            return;
        }

        try {
            DrawingApi drawingApi = getDrawingApi(GraphicsApi.valueOf(args[0].toUpperCase()));
            Graph graph = getGraph(drawingApi, GraphRepresentation.valueOf(args[1].toUpperCase()), Path.of(args[2]));
            graph.drawGraph();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static DrawingApi getDrawingApi(GraphicsApi graphicsApi) {
        return switch (graphicsApi) {
            case JAVAFX -> new JavaFxDrawing();
            case AWT -> new AwtDrawing();
        };
    }

    private static Graph getGraph(DrawingApi drawingApi, GraphRepresentation graphMode, Path path) throws IOException {
        return switch (graphMode) {
            case LIST -> new ListGraph(drawingApi, path);
            case MATRIX -> new MatrixGraph(drawingApi, path);
        };
    }

    private enum GraphRepresentation {LIST, MATRIX}
    private enum GraphicsApi {JAVAFX, AWT}
}