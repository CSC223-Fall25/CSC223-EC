package csc223.ec;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Note: updated after finishing HardLeetcode.java, realized that this was wrong, the priorityQueue didn't actually have the distances.
//made the minheap store both the vertex and the distance in an array with comparator to specify the index. EC

public class WeightedGraph implements WeightedGraphInterface {
    int[][] graph;
    PriorityQueue<int[]> minHeap;
    int[] distances;
    int[] predecesor;


    public WeightedGraph(int numVerticies) {
        this.graph = new int[numVerticies][numVerticies];
        this.predecesor = new int[numVerticies];
        this.distances = new int[numVerticies];
    }

    public WeightedGraph() {
        this.graph = new int[10][10];
        this.predecesor = new int[10];
        this.distances = new int[10];
    }

    /**
     * Adds an edge between two vertices with the given weight.
     * 
     * @param v1 the first vertex
     * @param v2 the second vertex
     * @param weight the weight of the edge
     */
    public void addEdge(int v1, int v2, double weight) {
        if ((v1 < graph.length) && (v2 < graph.length)) {
            this.graph[v1][v2] = (int) weight;
        }
    }

    public void addEdge(int v1, int v2) {
        if ((v1 < graph.length) && (v2 < graph.length)) {
            this.graph[v1][v2] = 1;
        }
    }
    
    /**
     * Gets the weight of the edge between two vertices.
     * 
     * @param v1 the first vertex
     * @param v2 the second vertex
     * @return the weight of the edge, or -1 if no edge exists
     */
    public double getEdgeWeight(int v1, int v2) {
        return this.graph[v1][v2];
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
            if (this.graph[vertex][i] != 0) {
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
     * Returns both the path and the total distance as a formatted string.
     * 
     * @param startVertex the starting vertex
     * @param endVertex the ending vertex
     * @return a string containing the shortest path and its total distance
     */
    public String shortestPath(int startVertex, int endVertex) {
        //Initialize the distance to the source vertex as 0 and the distance to all other vertices as infinity.
        Arrays.fill(this.distances, Integer.MAX_VALUE);
        Arrays.fill(this.predecesor, 0);
        this.distances[startVertex] = 0;
        this.predecesor[startVertex] = startVertex;

        //Create a priority queue to store vertices and their distances from the source vertex.
        this.minHeap = new PriorityQueue<int[]>(Comparator.comparingInt(vertex -> vertex[1]));
        int[] tempArray = new int[]{startVertex, 0};
        this.minHeap.add(tempArray);

        //While the priority queue is not empty:
        while (!this.minHeap.isEmpty()) {

            // Dequeue the vertex with the minimum distance from the priority queue.
            int[] currList = this.minHeap.peek();
            int currVertex = currList[0];
            this.minHeap.remove(currList);

            // For each neighbor of the dequeued vertex:
            int[] neighbors = getNeighbors(currVertex);
            for (int i = 0; i<neighbors.length; i++) {
                int neighbor = neighbors[i];

                // Calculate the distance to the neighbor through the dequeued vertex.
                int neighborDistance = this.distances[currVertex] + this.graph[currVertex][neighbor];
                if ((neighborDistance < this.distances[neighbor]) && (this.predecesor[neighbor] == 0) ) {

                    // If the new distance is less than the current distance to the neighbor,
                    //  update the distance and enqueue the neighbor.
                    this.distances[neighbor] = neighborDistance;
                    tempArray = new int[]{neighbor, neighborDistance};
                    this.minHeap.add(tempArray);
                    this.predecesor[neighbor] = currVertex;
                }
            }
        }
        //loop backwards through predecesor to get string path
        int currVertex = endVertex;
        String path = new String();
        while (currVertex != startVertex) {
            path += currVertex + " >-- ";
            currVertex = this.predecesor[currVertex];
        }
        path += startVertex;

        //loop backwards through path to make final string

        String stringPath = new String();

        for (int i=path.length()-1; i>1; i--) {
            stringPath += path.charAt(i);
        }
        stringPath += " " + endVertex;

        return stringPath;
    }
}
