package csc223.ec;

//https://leetcode.com/problems/find-center-of-star-graph/description/

public class Easy1Leetcode {
    public int findCenter(int[][] edges) {
        // First Edge Vertices
        int firstEdgeFirstVertex =  edges[0][0];
        int firstEdgeSecondVertex =  edges[0][1];
        // Second Edge Vertices
        int secondEdgeFirstVertex =  edges[1][0];
        int secondEdgeSecondVertex =  edges[1][1];

        if (firstEdgeFirstVertex == secondEdgeFirstVertex || firstEdgeFirstVertex == secondEdgeSecondVertex) {
            return firstEdgeFirstVertex;
        } else {
            return firstEdgeSecondVertex;
        }
    }
}