package csc223.ec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UnweightedGraphTest {
    UnweightedGraph testUnweightedGraph;

    @BeforeEach
    void setup(){
        // create a new weighted graph
        testUnweightedGraph = new UnweightedGraph(5);
    }

    @Test
    void testAddEdge(){
        testUnweightedGraph.addEdge(1, 2);
        Assertions.assertTrue(testUnweightedGraph.hasEdge(1,2));
        
    }

    @Test
    void testRemoveEdge(){
        testUnweightedGraph.addEdge(1, 2);
        Assertions.assertTrue(testUnweightedGraph.hasEdge(1,2));

        testUnweightedGraph.removeEdge(1,2);
        Assertions.assertFalse(testUnweightedGraph.hasEdge(1,2));

    }

    @Test
    void testHasEdge(){
        testUnweightedGraph.addEdge(1, 2);
        Assertions.assertTrue(testUnweightedGraph.hasEdge(1,2));
    }

    @Test
    void testGetNeighbors(){
        testUnweightedGraph.addEdge(0, 1);
        testUnweightedGraph.addEdge(0, 2);

        int[] graphNeighbors = testUnweightedGraph.getNeighbors(0);

        System.out.println(graphNeighbors);

    }

    @Test
    void testGetNumVertices(){
        Assertions.assertEquals(5, testUnweightedGraph.getNumVertices());

    }

    @Test
    void testPrintGraph(){
        testUnweightedGraph.printGraph();
    }

    @Test
    void testShortestPath(){
        testUnweightedGraph.addEdge(4, 5);
        testUnweightedGraph.addEdge(2, 3);
        testUnweightedGraph.addEdge(0, 1);

        String shortestPath = testUnweightedGraph.shortestPath(0,3);

        System.out.println(shortestPath);
    }



}

