//import org.graphstream.graph.*;
//import org.graphstream.graph.implementations.SingleGraph;
//import algorithms.*;
//
//import java.util.Random;
//
//public class Main2 {
//
//    public static void main(String[] args) throws InterruptedException {
//        while (true) { // Loop to allow graph re-generation for each run
//            Graph graph = new SingleGraph("RandomGraph");
//            System.setProperty("org.graphstream.ui", "swing");
//            graph.setAttribute("ui.stylesheet", "node { fill-color: red; } edge { fill-color: grey; }");
//            graph.display();
//
//            // Generate a random graph
//            generateRandomGraph(graph);
//
//
//            // Select start and target nodes randomly
//            Node startNode = graph.getNode("A");
//            Node targetNode = graph.getNode("G");
//
//            System.out.println("Running Hill Climbing:");
//            HillClimb.hillClimbing(graph, startNode, targetNode, 500, 500);
//            resetGraph(graph);
//        }
//    }
//
//    private static void generateRandomGraph(Graph graph) {
//        // Generate random nodes
//        for (char i = 'A'; i <= 'G'; i++) {
//            graph.addNode(String.valueOf(i)).setAttribute("ui.label", String.valueOf(i));
//        }
//
//        Random rand = new Random();
//        for (char i = 'A'; i < 'G'; i++) {
//            String from = String.valueOf(i);
//            String to = String.valueOf((char) (i + 1));
//            addEdgeWithRandomLength(graph, from, to, rand);
//        }
//    }
//
//    private static void addEdgeWithRandomLength(Graph graph, String from, String to, Random rand) {
//        if (graph.getNode(from) != null && graph.getNode(to) != null) {
//            double length = 1 + rand.nextDouble() * 10; // Random length between 1 and 10
//            Edge edge = graph.addEdge(from + to, from, to);
//            edge.setAttribute("length", length);
//            edge.setAttribute("ui.label", String.format("%.1f", length));
//        }
//    }
//
//    private static void resetGraph(Graph graph) {
//        graph.getNodeSet().forEach(n -> {
//            n.setAttribute("ui.style", "fill-color: red;");
//            n.removeAttribute("visited");
//            n.removeAttribute("distance");
//            n.removeAttribute("pathCost");
//            n.removeAttribute("totalCostEstimate");
//            n.removeAttribute("priority");
//            n.setAttribute("label", n.getId());
//        });
//
//        graph.getEdgeSet().forEach(e -> e.setAttribute("ui.style", "fill-color: grey;"));
//    }
//}
