package csc223.ec;

/**
 * Interface representing a graph data structure.
 */
public interface Graph {
    
    /**
     * Adds an edge between two vertices.
     * 
     * @param v1 the first vertex
     * @param v2 the second vertex
     */
    void addEdge(int v1, int v2);
    
    /**
     * Removes the edge between two vertices.
     * 
     * @param v1 the first vertex
     * @param v2 the second vertex
     */
    void removeEdge(int v1, int v2);
    
    /**
     * Checks if there is an edge between two vertices.
     * 
     * @param v1 the first vertex
     * @param v2 the second vertex
     * @return true if an edge exists, false otherwise
*/
boolean hasEdge(int v1, int v2);
    
/**
 * Gets all neighbors of the given vertex.
 * 
 * @param vertex the vertex to find neighbors for
 * @return an array of neighboring vertices
 */
int[] getNeighbors(int vertex);

/**
 * Gets the number of vertices in the graph.
 * 
 * @return the number of vertices
 */
int getNumVertices();

/**
 * Prints the graph representation.
 */
void printGraph();

/**
 * Finds the shortest path between two vertices.
 * 
 * @param startVertex the starting vertex
 * @param endVertex the ending vertex
 * @return the shortest path as a string representation, or null if no path exists
 */
String shortestPath(int startVertex, int endVertex);
}
