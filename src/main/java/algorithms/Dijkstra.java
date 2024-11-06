package algorithms;

import org.graphstream.graph.*;
import java.util.LinkedList;
import java.util.Queue;

public class Dijkstra {

    public static void dijkstra(Graph graph, Node startNode, int nodeVisitDelay, int edgeVisitDelay) throws InterruptedException {
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);

        initializeNodeAttributes(graph, startNode);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            markNodeVisited(current, "blue", nodeVisitDelay);

            for (Edge edge : current.getEdgeSet()) {
                Node neighbor = edge.getOpposite(current);
                double newDistance = calculateNewDistance(current, edge);

                if (isShorterPath(neighbor, newDistance)) {
                    updateNeighborDistance(neighbor, newDistance, queue);
                    markEdgeTraversed(edge, edgeVisitDelay);
                }
            }
        }

        markNodeVisited(startNode, "pink", nodeVisitDelay);
    }

    private static void initializeNodeAttributes(Graph graph, Node startNode) {
        graph.getNodeSet().forEach(n -> n.setAttribute("distance", Double.POSITIVE_INFINITY));//svi cvorovi su setovani na +infinity
        startNode.setAttribute("distance", 0.0); //samo pocetni cvor ima predjeni put 0
    }

    private static double calculateNewDistance(Node current, Edge edge) {
        return (double) current.getAttribute("distance") + (double) edge.getAttribute("length");
    }

    private static boolean isShorterPath(Node neighbor, double newDistance) {
        return newDistance < (double) neighbor.getAttribute("distance");
    }

    private static void updateNeighborDistance(Node neighbor, double newDistance, Queue<Node> queue) {
        neighbor.setAttribute("distance", newDistance);
        neighbor.setAttribute("label", "Distance: " + newDistance);
        queue.add(neighbor);
        neighbor.setAttribute("ui.style", "fill-color: green;");
    }

    private static void markNodeVisited(Node node, String color, int delay) throws InterruptedException {
        node.setAttribute("ui.style", "fill-color: " + color + ";");
        Thread.sleep(delay);
    }

    private static void markEdgeTraversed(Edge edge, int delay) throws InterruptedException {
        edge.setAttribute("ui.style", "fill-color: blue;");
        Thread.sleep(delay);
    }
}
