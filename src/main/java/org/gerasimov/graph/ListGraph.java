package org.gerasimov.graph;

import org.gerasimov.drawing.DrawingApi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael Gerasimov
 */
public class ListGraph extends Graph {
    private final List<List<Integer>> graph;

    public ListGraph(DrawingApi drawingApi, Path path) throws IOException {
        super(drawingApi);
        this.graph = read(Files.readString(path));
    }

    private static List<List<Integer>> read(String stringFile) {
        List<List<Integer>> graph = new ArrayList<>();
        List<String> lines = stringFile.lines().toList();
        int size = Integer.parseInt(lines.get(0));

        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }

        lines.stream().skip(1).forEach(
                line -> {
                    String[] split = line.split(" ");
                    int a = Integer.parseInt(split[0]);
                    int b = Integer.parseInt(split[1]);
                    graph.get(a).add(b);
                }
        );

        return graph;
    }

    @Override
    public void drawGraph() {
        for (int a = 0; a < graph.size(); a++) {
            drawVertex(a);
            for (int b : graph.get(a)) {
                drawEdge(a, b);
            }
        }
        getDrawingApi().draw();
    }

    @Override
    public int size() {
        return graph.size();
    }
}
