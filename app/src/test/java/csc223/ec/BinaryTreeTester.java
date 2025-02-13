package csc223.ec;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class BinaryTreeTester {
    
    BinaryTree testTree;
    
    @BeforeEach
    void setup() {
        testTree = new BinaryTree('A');
        testTree.insert('B');
        testTree.insert('C');
        testTree.insert('D');
        testTree.insert('E');
        testTree.insert('F');
        testTree.insert('G');
    }

    @Test
    void testInsert() {
        BinaryTree testTree2 = new BinaryTree('A');

        testTree2.insert('B');
        testTree2.insert('C');
        
        assertEquals('B', testTree2.levelorder().charAt(1));
        assertEquals('C', testTree2.levelorder().charAt(2));
    }

    @Test
    void testHeight() {
        assertEquals(3, testTree.height());

        testTree.insert('H');

        assertEquals(4, testTree.height());
    }

    @Test
    void testSize() {
        assertEquals(7, testTree.size());
    }

    @Test
    void testSearch() {
        assertEquals(true, testTree.search('G'));
        assertEquals(false, testTree.search('L'));
    }

    @Test
    void testlevelOrder() {
        assertEquals('A', testTree.levelorder().charAt(0));    
        assertEquals('B', testTree.levelorder().charAt(1));
        assertEquals('C', testTree.levelorder().charAt(2));
        assertEquals('D', testTree.levelorder().charAt(3));    
        assertEquals('E', testTree.levelorder().charAt(4));
        assertEquals('F', testTree.levelorder().charAt(5));
        assertEquals('G', testTree.levelorder().charAt(6));
    }

    @Test
    void testpreOrder() {
        assertEquals('A', testTree.preorder().charAt(0));    
        assertEquals('B', testTree.preorder().charAt(1));
        assertEquals('D', testTree.preorder().charAt(2));
        assertEquals('E', testTree.preorder().charAt(3));    
        assertEquals('C', testTree.preorder().charAt(4));
        assertEquals('F', testTree.preorder().charAt(5));
        assertEquals('G', testTree.preorder().charAt(6));
    }

    @Test
    void testinOrder() {
        assertEquals('D', testTree.inorder().charAt(0));    
        assertEquals('B', testTree.inorder().charAt(1));
        assertEquals('E', testTree.inorder().charAt(2));
        assertEquals('A', testTree.inorder().charAt(3));    
        assertEquals('F', testTree.inorder().charAt(4));
        assertEquals('C', testTree.inorder().charAt(5));
        assertEquals('G', testTree.inorder().charAt(6));
    }

    @Test
    void testpostOrder() {
        assertEquals('D', testTree.postorder().charAt(0));    
        assertEquals('E', testTree.postorder().charAt(1));
        assertEquals('B', testTree.postorder().charAt(2));
        assertEquals('F', testTree.postorder().charAt(3));    
        assertEquals('G', testTree.postorder().charAt(4));
        assertEquals('C', testTree.postorder().charAt(5));
        assertEquals('A', testTree.postorder().charAt(6));
    }

}
