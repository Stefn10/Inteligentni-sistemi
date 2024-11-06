package algorithms;

import org.graphstream.graph.*;

import java.util.Iterator;

public class HillClimb {

    public static void hillClimbing(Graph graph, Node startNode, Node targetNode, int nodeVisitDelay, int edgeVisitDelay) throws InterruptedException {
        startNode.setAttribute("ui.color", 0);
        Node currentNode = startNode;

        while (!currentNode.equals(targetNode)) {
            Iterator<Node> neighborIterator = currentNode.getNeighborNodeIterator();
            currentNode.setAttribute("ui.style", "fill-color: blue;");

            Node bestNeighbor = null;
            double bestWeight = Double.MAX_VALUE;

            while (neighborIterator.hasNext()) {
                Node neighbor = neighborIterator.next();
                Edge edge = currentNode.getEdgeBetween(neighbor);

                neighbor.setAttribute("ui.style", "fill-color: green;");
                Thread.sleep(500);  // Задержка, чтобы визуализировать процесс

                if (edge != null) {
                    double weight = edge.getAttribute("length");

                    if (weight < bestWeight) {
                        bestWeight = weight;
                        bestNeighbor = neighbor;
                    }

                    edge.setAttribute("ui.style", "fill-color: blue;");
                    Thread.sleep(500);  // Задержка для визуализации
                }
            }

            if (bestNeighbor == null || bestWeight >= getEdgeWeight(currentNode, bestNeighbor)) {
                System.out.println("Lokalni ekstremum " + currentNode.getId());
            }
            currentNode = bestNeighbor;
        }

        System.out.println("Pronasli krajnji cvor");
        currentNode.setAttribute("ui.style", "fill-color: orange;");
    }

    // Метод для получения веса ребра между двумя узлами
    private static double getEdgeWeight(Node from, Node to) {
        Edge edge = from.getEdgeBetween(to);
        return edge.getAttribute("length");
    }
}
