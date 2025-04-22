package csc223.ec;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class BinarySearchTreeTest {
    BinarySearchTree TestTree;

    @BeforeEach
    void setup() {
        TestTree = new BinarySearchTree(15);
        TestTree.insert(10);
        TestTree.insert(5);
        TestTree.insert(12);
        TestTree.insert(18);
        TestTree.insert(20);
        TestTree.insert(25);
        //      15
        //     /   \
        //    10    18
        //   /\     / \
        //  5  12  20 25
    }

    @Test
    void testisEmpty() {
        BinarySearchTree emptyTree = new BinarySearchTree(0);
        emptyTree.delete(0);
        assertTrue(emptyTree.isEmpty());
    }

    @Test
    void testInsert() {
        TestTree.insert(12);
        TestTree.insert(11);
        assertEquals("5 10 11 12 12 15 18 20 25", TestTree.inorder());
    }

    @Test
    void testDelete() {
        //Deleting on left
        TestTree.delete(10);
        assertEquals("5 12 15 18 20 25", TestTree.inorder());

        //Deleting root
        TestTree.delete(15);
        assertEquals("5 12 18 20 25", TestTree.inorder());

        //Deleting on right side
        setup();
        TestTree.delete(18);
        assertEquals("5 10 12 15 20 25", TestTree.inorder());

        //delete everything
        int[] deleteList = {5, 10, 12, 15, 18, 20, 25};
        int i = 0;
        while (TestTree.isEmpty() == false) {
            TestTree.delete(deleteList[i]);
            i++;
        }

        assertTrue(TestTree.isEmpty());
    }

    @Test
    void testUpdate() {
        //Updating random node
        TestTree.update(20,21);
        assertEquals("5 10 12 15 18 21 25", TestTree.inorder());

        //Updating root
        TestTree.update(15, 19);
        assertEquals("5 10 12 18 19 21 25", TestTree.inorder());

    }

    @Test
    void testSearch() {
        assertTrue(TestTree.search(18));
    }

    @Test
    void testsortedArrayToBST() {
        int[] sortedArray = {-10,-3,0,5,9};
        BinarySearchTree ArrayTree = new BinarySearchTree(6);
        ArrayTree.sortedArrayToBST(sortedArray);

        assertEquals("-10 -3 0 5 6 9", ArrayTree.inorder());
    }

    @Test
    void testlowestCommonAncestor() {
        //Testing normal num on left
        assertEquals(10, TestTree.lowestCommonAncestor(5, 12));

        //Testing for lca of itself (18)
        assertEquals(18, TestTree.lowestCommonAncestor(18, 25));

        //Testing for either not in list
        assertEquals(-1, TestTree.lowestCommonAncestor(0, 0));
        assertEquals(-1, TestTree.lowestCommonAncestor(3, 4));
    }



}
