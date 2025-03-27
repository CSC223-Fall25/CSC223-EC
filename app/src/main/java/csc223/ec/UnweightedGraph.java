package csc223.ec;

import java.util.Arrays;

public class UnweightedGraph implements Graph {

    int[][] graph;

    public UnweightedGraph(int vertices) {
        this.graph = new int[vertices][vertices];
    }
    
    /**
     * Adds an edge between two vertices.
     * 
     * @param v1 the first vertex
     * @param v2 the second vertex
     */
    public void addEdge(int v1, int v2) {
        if ((v1 < this.graph.length) && (v2 < this.graph.length)) {
            this.graph[v1][v2] = 1;
        }
    }

    /**
     * Removes the edge between two vertices.
     * 
     * @param v1 the first vertex
     * @param v2 the second vertex
     */
    public void removeEdge(int v1, int v2) {
        if ((v1 < this.graph.length) && (v2 < this.graph.length)) {
            this.graph[v1][v2] = 0;
        }
    }

    /**
     * Checks if there is an edge between two vertices.
     * 
     * @param v1 the first vertex
     * @param v2 the second vertex
     * @return true if an edge exists, false otherwise
    */
    public boolean hasEdge(int v1, int v2) {
        return (this.graph[v1][v2] == 1);
    }

    /**
     * Gets all neighbors of the given vertex.
     * 
     * @param vertex the vertex to find neighbors for
     * @return an array of neighboring vertices
     */
    public int[] getNeighbors(int vertex) {
        int[] neighbors = new int[this.graph.length];
        int curr = 0;
        for (int i = 0; i < this.graph.length; i++) {
            if (this.graph[vertex][i] == 1) {
                neighbors[curr] = i;
                curr += 1;
            }
        }
        return neighbors;
    }

    /**
    * Gets the number of vertices in the graph.
    * 
    * @return the number of vertices
    */
    public int getNumVertices() {
        return this.graph.length;
    }

    /**
     * Prints the graph representation.
     */
    public void printGraph() {
        String row = "";
        for (int i = 0; i < this.graph.length; i++) {
            row = "";
            for (int j = 0; j < this.graph.length; j++) {
                row = row + this.graph[i][j] + " ";
            }
            System.out.println(row);
        }
    }

    /**
     * Finds the shortest path between two vertices.
     * 
     * @param startVertex the starting vertex
     * @param endVertex the ending vertex
     * @return the shortest path as a string representation, or null if no path exists
     */
    public String shortestPath(int startVertex, int endVertex) {
        int[] predecessors = new int[this.graph.length];
        Arrays.fill(predecessors, -1);
        ArrayQueue queue = new ArrayQueue();
        int curr = 0;
        queue.enqueue(startVertex);
        while (!queue.isEmpty()) {
            curr = queue.dequeue();
            for (int i = 0; i <= this.graph.length; i++) {
                // Check if there's an edge to an unvisited vertex
                if ((this.graph[curr][i] == 1) && (predecessors[i] == -1)) {
                    queue.enqueue(this.graph[curr][i]);
                    predecessors[i] = curr;
                }
            }
        }
        return "";
    }
}
