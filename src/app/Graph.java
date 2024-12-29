package app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    private final Map<Integer, Set<Integer>> graphList = new HashMap<>();

    public Graph addVertex(int vertex) {
        graphList.putIfAbsent(vertex, new HashSet<>());

        return this;
    }
    public Graph addEdge(int source, int destination) {
        addVertex(source);
        addVertex(destination);

        graphList.get(source).add(destination);
        graphList.get(destination).add(source);

        return this;
    }
    public void removeVertex(int vertex) {
        if (graphList.containsKey(vertex)) {
            for (int neighbor : graphList.get(vertex)) {
                graphList.get(neighbor).remove(vertex);
            }
            graphList.remove(vertex);
        }
    }
    public void removeEdge(int source, int destination) {
        if (graphList.containsKey(source)) {
            graphList.get(source).remove(destination);
        }
        if (graphList.containsKey(destination)) {
            graphList.get(destination).remove(source);
        }
    }
    public boolean hasVertex(int vertex) {
        return graphList.containsKey(vertex);
    }
    public boolean hasEdge(int source, int destination) {
        return graphList
                .containsKey(source) &&
                    graphList
                        .get(source)
                        .contains(destination);
    }
    public void printGraph() {
        for (Map.Entry<Integer, Set<Integer>> entry : graphList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

}
