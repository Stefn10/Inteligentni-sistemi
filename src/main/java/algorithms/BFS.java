package algorithms;

import org.graphstream.graph.*;
import java.util.LinkedList;
import java.util.Queue;

public class BFS { /// Pretraga po sirini

    public static void bfs(Graph graph, Node startNode, int nodeVisitDelay, int edgeVisitDelay) throws InterruptedException {
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);

        //Inicijalizuje pocetni node i stavlja mu boju
        markNodeVisited(startNode, "blue");

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            //Kada je cvor posecen, promeni boju
            markNodeVisited(current, "darkblue");
            Thread.sleep(nodeVisitDelay);

            //Prolazi kroz sve susede
            for (Edge edge : current.getEdgeSet()) {
                Node neighbor = edge.getOpposite(current);

                if (!isVisited(neighbor)) {
                    //Oboj suseda koga jos nismo otvorili
                    markNodeVisited(neighbor, "green");
                    queue.add(neighbor);
                    //oboj granu kojom smo prosli
                    markEdgeTraversed(edge, "blue");
                    Thread.sleep(edgeVisitDelay);
                }
            }
        }
    }

    //Boji posecen cvor
    private static void markNodeVisited(Node node, String color) {
        node.setAttribute("visited", true);
        node.setAttribute("ui.style", "fill-color: " + color + ";");
    }
    //Boji posecenu granu
    private static void markEdgeTraversed(Edge edge, String color) {
        edge.setAttribute("ui.style", "fill-color: " + color + ";");
    }
    //Proverava da li je node posecen
    private static boolean isVisited(Node node) {
        return node.getAttribute("visited") != null;
    }
}