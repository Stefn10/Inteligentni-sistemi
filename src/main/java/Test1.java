//
//import algorithms.BestFirstSearch;
//import algorithms.DFS;
//import algorithms.Dijkstra;
//import algorithms.HillClimb;
//import org.graphstream.graph.*;
//import org.graphstream.graph.implementations.SingleGraph;
//import algorithms.*;
//import graphGenerator.GraphGenerator;
//import graphVisualization.GraphVisualization;
//import org.jgrapht.graph.DefaultEdge;
//import java.util.Random;
//import java.util.Scanner;
//
//    public class Test1 {
//            public static void main(String[] args) throws InterruptedException {
//                // Настройка системы для отображения графа
//                System.setProperty("org.graphstream.ui", "swing");
//
//                // Get user choice for algorithm
//                System.out.println("1: BFS, 2: DFS, 3: Dijkstra, 4: A*, 5: HillClimbing, 6: Best-first search");
//                System.out.println("Choose algorithm: ");
//
//                Scanner scanner = new Scanner(System.in);
//                int choice = scanner.nextInt();
//                int heuristic_choice = 0;
//
//                if (choice == 4) {
//                    System.out.println("1: heuristic_equals_null, 2: heuristic_c_min, 3: heuristic_c_average, 4: heuristic_c_min_average 5: heuristic_degree");
//                    System.out.println("Choose heuristic: ");
//                    heuristic_choice = scanner.nextInt();
//                }
//
//                // Generate a random graph using the GraphGenerator class
//                int numVertices = 10;
//                int numEdges = 15;
//                Graph<String, DefaultEdge> graph = GraphGenerator.generateRandomGraph(numVertices, numEdges);
//
//                // Visualize the graph using GraphVisualization class
//                GraphVisualization.visualize(graph);
//
//                // Z задержка перед началом обхода, чтобы граф отобразился
//                Thread.sleep(2000);
//
//                // Choose the starting node and target node
//                String startNodeId = "Node0";  // Start node
//                String targetNodeId = "Node9"; // Target node
//
//                switch (choice) {
//                    case 1:
//                        BFS.bfs(graph, startNodeId);
//                        break;
//                    case 2:
//                        DFS.dfs(graph, startNodeId);
//                        break;
//                    case 3:
//                        Dijkstra.dijkstra(graph, startNodeId);
//                        break;
//                    case 4:
//                        Astar.astar(graph, startNodeId, targetNodeId, heuristic_choice);
//                        break;
//                    case 5:
//                        HillClimb.hillClimbing(graph, startNodeId, targetNodeId, 1000, 1000);
//                        break;
//                    case 6:
//                        BestFirstSearch.bestFirstSearch(graph, startNodeId, targetNodeId);
//                        break;
//
//                    default:
//                        BFS.bfs(graph, startNodeId);
//                        break;
//                }
//            }
//    }
