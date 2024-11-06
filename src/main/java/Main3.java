//import algorithms.HillClimb;
//import graphGenerator.GraphGenerator;
//import org.graphstream.graph.Node;
//import org.graphstream.graph.implementations.SingleGraph;
//import org.jgrapht.Graph;
//import org.jgrapht.graph.DefaultEdge;
//
//public class Main3 {
//    public static void main(String[] args) {
//        Graph<String, DefaultEdge> jGraphTGraph = GraphGenerator.generateComplexGraph(10, 20); // 10 nodes, 20 edges
//        SingleGraph graphStreamGraph = GraphConverter.convertToGraphStream(jGraphTGraph);
//
//        // Display the graph
//        graphStreamGraph.display();
//
//        // Run your algorithms here, for example:
//        Node startNode = graphStreamGraph.getNode("Node_0"); // Start node
//        Node targetNode = graphStreamGraph.getNode("Node_9"); // Target node
//
//        try {
//            HillClimb.hillClimbing(graphStreamGraph, startNode, targetNode, 1000, 500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
