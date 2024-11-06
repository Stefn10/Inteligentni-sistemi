//import org.graphstream.graph.*;
//import org.graphstream.graph.implementations.SingleGraph;
//
//public class Main {
//    public static void main(String[] args) throws InterruptedException {
//        Graph graph = new SingleGraph("A* Visualization");
//
//        // Initialize graph with nodes and edges, and set edge lengths
//        Node startNode = graph.getNode("Start"); // Assuming a node "Start" exists
//        Node targetNode = graph.getNode("Goal"); // Assuming a node "Goal" exists
//
//        int heuristicChoice = 2;       // Choose heuristic type
//        int nodeVisitDelay = 1000;     // Delay in ms for visiting nodes
//        int edgeVisitDelay = 500;      // Delay in ms for visiting edges
//
//        AStar.astar(graph, startNode, targetNode, heuristicChoice, nodeVisitDelay, edgeVisitDelay);
//    }
//}
//
