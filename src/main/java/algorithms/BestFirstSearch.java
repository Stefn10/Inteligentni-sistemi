package algorithms;

import org.graphstream.graph.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BestFirstSearch {

    public static void bestFirstSearch(Graph graph, Node startNode, Node targetNode, int nodeVisitDelay, int edgeVisitDelay) throws InterruptedException {
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingDouble(n -> (double) n.getAttribute("priority")));
        openSet.add(startNode);

        // Initialize starting node's priority
        startNode.setAttribute("priority", heuristicMinAverage(startNode, targetNode));

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();
            markNodeVisited(current, "blue", nodeVisitDelay);

            if (current.equals(targetNode)) {
                markNodeVisited(current, "orange", nodeVisitDelay);
                break;
            }

            for (Edge edge : current.getEdgeSet()) {
                Node neighbor = edge.getOpposite(current);
                double priority = heuristicMinAverage(neighbor, targetNode);
                updateNeighborPriority(neighbor, priority, openSet);
                markEdgeTraversed(edge, edgeVisitDelay);
            }
        }

        markNodeVisited(startNode, "pink", nodeVisitDelay); // Optional: Reset start node color
    }

    private static void updateNeighborPriority(Node neighbor, double priority, PriorityQueue<Node> openSet) {
        neighbor.setAttribute("priority", priority);
        neighbor.setAttribute("label", "priority: " + priority);

        openSet.remove(neighbor); // Remove outdated priority if present
        openSet.add(neighbor);    // Re-add with updated priority
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

    private static double heuristicMinAverage(Node current, Node target) {
        double sumEdgeLengths = current.getEdgeSet().stream()
                .mapToDouble(e -> (double) e.getAttribute("length"))
                .sum();
        return sumEdgeLengths / current.getDegree();
    }
}

