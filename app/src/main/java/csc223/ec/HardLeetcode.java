package csc223.ec;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/design-graph-with-shortest-path-calculator/description/

public class HardLeetcode {
    class Graph {
        int[][] graph;
        //crrate a priority Queue of lists
        PriorityQueue<int[]> minHeap;
        int numNodes;


        public Graph(int n, int[][] edges) {
            this.numNodes = n;
            this.graph = new int[this.numNodes][this.numNodes];

            for (int i=0; i<edges.length; i++) {
                this.addEdge(edges[i]);
            }
        }
        
        public void addEdge(int[] edge) {
            if (this.graph[edge[0]][edge[1]] == 0) {
                this.graph[edge[0]][edge[1]] = edge[2];
            }
        }
        
        public int shortestPath(int node1, int node2) {
            //Initialize the distance to the source vertex as 0 and the distance to all other vertices as infinity.
            int[] distances = new int[this.numNodes];
            boolean[] visitor = new boolean[this.numNodes];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[node1] = 0;

            // Create a priority queue to store vertices and their distances from the source vertex.
            //specify the index of the array that the minheap is sorting by
            this.minHeap = new PriorityQueue<int[]>(Comparator.comparingInt(v -> v[1]));
            int[] tempArray = new int[]{node1,0};
            this.minHeap.add(tempArray);

            // While the priority queue is not empty:
            while (!this.minHeap.isEmpty()) {
                // Dequeue the vertex with the minimum distance from the priority queue.
                int[] currList = this.minHeap.peek();
                int currVertex = currList[0];
                int currDistance = currList[1];
                this.minHeap.remove(currList);

                if (visitor[currVertex] == true) {
                    continue;
                }
                visitor[currVertex] = true;

                // For each neighbor of the dequeued vertex:
                for (int i = 0; i < this.numNodes; i++) {
                    if (this.graph[currVertex][i] != 0) {
                        // Calculate the distance to the neighbor through the dequeued vertex.
                        int neighborDistance = currDistance + this.graph[currVertex][i];

                        // If the new distance is less than the current distance to the neighbor, update the distance and enqueue the neighbor.
                        if (neighborDistance < distances[i]) {

                            distances[i] = neighborDistance;
                            tempArray = new int[]{i, neighborDistance};
                            this.minHeap.add(tempArray);
                        }
                    }
                }
            }
            if (distances[node2] == Integer.MAX_VALUE) {
                return -1;
            }
            return distances[node2];
        }
    }
    
    /**
     * Your Graph object will be instantiated and called as such:
     * Graph obj = new Graph(n, edges);
     * obj.addEdge(edge);
     * int param_2 = obj.shortestPath(node1,node2);
     */
}
