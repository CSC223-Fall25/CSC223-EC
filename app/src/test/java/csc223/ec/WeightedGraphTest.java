package csc223.ec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeightedGraphTest {
    WeightedGraph testWeightedGraph;

    @BeforeEach
    void setup(){
        // create a new weighted graph
        testWeightedGraph = new WeightedGraph(5);
    }

    @Test
    void testAddEdge(){
        testWeightedGraph.addEdge(1, 2);
        Assertions.assertTrue(testWeightedGraph.hasEdge(1,2));
    }

    @Test
    void testRemoveEdge(){
        testWeightedGraph.addEdge(1, 2);
        Assertions.assertTrue(testWeightedGraph.hasEdge(1,2));

        testWeightedGraph.removeEdge(1,2);
        Assertions.assertFalse(testWeightedGraph.hasEdge(1,2));

    }

    @Test
    void testHasEdge(){
        testWeightedGraph.addEdge(1, 2);
        Assertions.assertTrue(testWeightedGraph.hasEdge(1,2));
    }

    @Test
    void testGetNeighbors(){
        testWeightedGraph.addEdge(0, 1);
        testWeightedGraph.addEdge(0, 2);

        int[] graphNeighbors = testWeightedGraph.getNeighbors(0);

        System.out.println(graphNeighbors);

    }

    @Test
    void testGetNumVertices(){
        Assertions.assertEquals(5, testWeightedGraph.getNumVertices());
        

    }

    @Test
    void testPrintGraph(){
        testWeightedGraph.printGraph();
        
    }

    @Test
    void testShortestPath(){
        testWeightedGraph.addEdge(4, 5, 7);
        testWeightedGraph.addEdge(2, 3, 6);
        testWeightedGraph.addEdge(0, 1, 5);

        String shortestPath = testWeightedGraph.shortestPath(0,3);
        System.out.println(shortestPath);
    }

    @Test
    void testGetEdgeWeight(){
        testWeightedGraph.addEdge(1,2);
        testWeightedGraph.addEdge(3, 4, -1);
        testWeightedGraph.addEdge(2, 3, 0);

        Assertions.assertEquals(1, testWeightedGraph.getEdgeWeight(1,2));
        Assertions.assertEquals(-1, testWeightedGraph.getEdgeWeight(3,4));
        Assertions.assertEquals(0, testWeightedGraph.getEdgeWeight(2,3));
    }

}

