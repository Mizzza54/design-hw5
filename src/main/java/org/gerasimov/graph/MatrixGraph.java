package org.gerasimov.graph;

import org.gerasimov.drawing.DrawingApi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * @author Michael Gerasimov
 */
public class MatrixGraph extends Graph {
    private final int[][] graph;

    public MatrixGraph(DrawingApi drawingApi, Path path) throws IOException {
        super(drawingApi);
        this.graph = read(Files.readString(path));
    }

    private static int[][] read(String stringFile) {
        List<String> lines = stringFile.lines().toList();
        int size = Integer.parseInt(lines.get(0));

        int[][] graph = new int[size][size];
        for (int a = 0; a < size; a++) {
            String[] line = lines.get(a + 1).split(" ");
            for (int b = 0; b < size; b++) {
                graph[a][b] = Integer.parseInt(line[b]);
            }
        }

        return graph;
    }

    @Override
    public void drawGraph() {
        for (int a = 0; a < size(); a++) {
            drawVertex(a);
            for (int b = 0; b < size(); b++) {
                if (graph[a][b] == 1) {
                    drawEdge(a, b);
                }
            }
        }
        getDrawingApi().draw();
    }

    @Override
    public int size() {
        return graph.length;
    }
}
