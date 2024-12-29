package app;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex(1)
             .addVertex(2);
        graph.addEdge(1, 2)
             .addEdge(1, 3)
             .addEdge(2, 4);

        System.out.println("Graph:");
        graph.printGraph();

        System.out.println("Has vertex 3: " + graph.hasVertex(3));
        System.out.println("Has edge (1, 4): " + graph.hasEdge(1, 4));

        graph.removeEdge(1, 2);
        System.out.println("Graph after removing edge (1, 2):");
        graph.printGraph();

        graph.removeVertex(3);
        System.out.println("Graph after removing vertex 3:");
        graph.printGraph();
    }
}
