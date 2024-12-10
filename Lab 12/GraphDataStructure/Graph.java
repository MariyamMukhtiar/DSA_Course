/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.techwebdocs.graph;

/**
 *
 * @author Dell
*/
import java.util.*;

public class Graph {
    private int vertices;
    private int[][] adjMatrix;

    // Constructor to initialize the graph with vertices
    public Graph(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    // Method to add an edge to the adjacency matrix
    public void addEdge(int u, int v) {
        adjMatrix[u - 1][v - 1] = 1;  // Convert to 0-based indexing
        adjMatrix[v - 1][u - 1] = 1;  // Because it's an undirected graph
    }

    // Method to display the adjacency matrix
    public void displayAdjMatrix() {
        System.out.println("Adjacency Matrix:");
        System.out.print("    ");
        for (int i = 0; i < vertices; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();

        for (int i = 0; i < vertices; i++) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to find the shortest path between two vertices using BFS
    public void bfsShortestPath(int start, int end) {
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1); // Initialize parent array to -1
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start - 1);
        visited[start - 1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end - 1) {
                break;
            }

            for (int i = 0; i < vertices; i++) {
                if (adjMatrix[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    parent[i] = current;
                    queue.add(i);
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        int node = end - 1;
        while (node != -1) {
            path.add(node + 1);
            node = parent[node];
        }

        if (path.isEmpty() || parent[end - 1] == -1) {
            System.out.println("No path found.");
            return;
        }

        Collections.reverse(path);
        System.out.print("Shortest Path: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i != path.size() - 1) {
                System.out.print(" → ");
            }
        }
        System.out.println();
        System.out.println("Length: " + (path.size() - 1));
    }

    // Method to find all paths between two vertices using DFS
    public void dfsAllPaths(int start, int end) {
        boolean[] visited = new boolean[vertices];
        List<Integer> path = new ArrayList<>();
        dfsHelper(start - 1, end - 1, visited, path);
    }

    private void dfsHelper(int current, int end, boolean[] visited, List<Integer> path) {
        visited[current] = true;
        path.add(current + 1);

        if (current == end) {
            System.out.print("Path: ");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i != path.size() - 1) {
                    System.out.print(" → ");
                }
            }
            System.out.println(" (Length: " + (path.size() - 1) + ")");
        } else {
            for (int i = 0; i < vertices; i++) {
                if (adjMatrix[current][i] == 1 && !visited[i]) {
                    dfsHelper(i, end, visited, path);
                }
            }
        }

        path.remove(path.size() - 1);
        visited[current] = false;
    }

    // Method to find the connected components of the graph
    public void detectConnectedComponents() {
        boolean[] visited = new boolean[vertices];
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfsForComponents(i, visited, component);
                components.add(component);
            }
        }

        System.out.println("Connected Components:");
        for (int i = 0; i < components.size(); i++) {
            System.out.print("Component " + (i + 1) + ": {");
            for (int j = 0; j < components.get(i).size(); j++) {
                System.out.print(components.get(i).get(j));
                if (j != components.get(i).size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("}");
        }
    }

    private void dfsForComponents(int current, boolean[] visited, List<Integer> component) {
        visited[current] = true;
        component.add(current + 1);  // Convert to 1-based indexing

        for (int i = 0; i < vertices; i++) {
            if (adjMatrix[current][i] == 1 && !visited[i]) {
                dfsForComponents(i, visited, component);
            }
        }
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        Graph graph = new Graph(4);

        // Add edges as per the example input
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);

        // Display the adjacency matrix
        graph.displayAdjMatrix();

        // Task 3: Find the shortest path between 1 and 4
        System.out.println("\nTask 3: Shortest Path Between 1 and 4");
        graph.bfsShortestPath(1, 4);

        // Task 4: Find all paths between 1 and 4
        System.out.println("\nTask 4: All Paths Between 1 and 4");
        graph.dfsAllPaths(1, 4);

        // Task 5: Detect connected components
        System.out.println("\nTask 5: Detect Connected Components");
        graph.detectConnectedComponents();
    }
}










