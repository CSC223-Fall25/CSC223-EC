package csc223.ec;
import java.util.ArrayList;
import java.util.LinkedList;

// https://leetcode.com/problems/find-if-path-exists-in-graph/description/

public class Easy2Leetcode {

    public class Solution {

        public boolean validPath(int n, int[][] edges, int source, int destination) {
            // Create an adjacency list for easier edge access
            ArrayList<LinkedList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new LinkedList<Integer>());
            }

            // Add all the edges
            for (int[] edge : edges) {
                int v = edge[0];
                int u = edge[1];

                graph.get(v).add(u);
                graph.get(u).add(v);
            }
            return validPath(graph, source, destination, new int[n]);
        }
        
        private boolean validPath(ArrayList<LinkedList<Integer>> graph, int curr, int destination, int[] visited) {
            // Mark curr as visited
            visited[curr] = 1;
            // Return true if destination found
            if (curr == destination) {
                return true;
            }
            for (int neighbor : graph.get(curr)) {
                // Check if there's an edge to an unvisited node
                if (visited[neighbor] == 0) {
                    if (validPath(graph, neighbor, destination, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }
   }
}