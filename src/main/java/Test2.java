
import algorithms.*;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.SingleGraph;

import java.util.Random;
import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) throws InterruptedException {
        // Initialize and configure the graph
        System.setProperty("org.graphstream.ui", "swing");

        Graph graph = new SingleGraph("TreeGraph");

        // Number of nodes
        int numNodes = 15;
        Random random = new Random();

        // Add nodes to the graph
        for (int i = 0; i < numNodes; i++) {
            graph.addNode("A " + i).setAttribute("ui.label", "A" + i);
        }

        // Connect each node to a random previous node to form a tree
        for (int i = 1; i < numNodes; i++) {
            int parent = random.nextInt(i);  // Ensure we only connect to previous nodes to keep it acyclic
            double randomLength = random.nextInt(15) + 1;
            graph.addEdge("Edge" + parent + "_" + i, "A " + parent, "A " + i)
                    .setAttribute("length", randomLength);
        }

        graph.setAttribute("ui.stylesheet", "node { fill-color: red; size: 20px; text-size: 20px; } edge { fill-color: black; text-size: 20px; }");
        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");

        graph.getEdgeSet().forEach(e -> e.setAttribute("label", "" + (int) e.getNumber("length")));

        graph.display();

        Thread.sleep(2000);


        System.out.println("1: Best-first search, 2: DFS, 3: A*, 4: HillClimbing, 5: BFS");
        System.out.println("Choose algorithm: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        int heuristic_choice = 0;

        switch (choice) {
                    case 1:
                        System.out.println("Running Best-First Search:");
                        BestFirstSearch.bestFirstSearch(graph, graph.getNode("A 0"), graph.getNode("A 14"), 500, 500);
                        break;
                    case 2:
                        System.out.println("Running Depth-First Search (DFS):");
                        DFS.dfs(graph, graph.getNode("A 0"), graph.getNode("A 14"),500, 500);
                        break;
                    case 3:
                        System.out.println("Running A* Search:");
                        Astar.astar(graph, graph.getNode("A 0"), graph.getNode("A 14"), 5, 500, 500);
                        break;
                    case 4:
                        System.out.println("Running Hill Climbing:");
                        HillClimb.hillClimbing(graph, graph.getNode("A 0"), graph.getNode("A 14"), 500, 500);
                        break;
                    case 5:
                        System.out.println("Running BFS");
                        BFS.bfs(graph, graph.getNode("A 0"), graph.getNode("A 14"),500, 500);
                    default:
                        System.out.println("Running Best-First Search:");
                        BestFirstSearch.bestFirstSearch(graph, graph.getNode("A 0"), graph.getNode("A 14"), 500, 500);
                        break;
                }
    }

}
