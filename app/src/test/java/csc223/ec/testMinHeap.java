package csc223.ec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testMinHeap {
    MinHeap testMinHeap;

    @BeforeEach
    void setup() {
        this.testMinHeap = new MinHeap();
        this.testMinHeap.insert('A');
        this.testMinHeap.insert('D');
        this.testMinHeap.insert('C');
        this.testMinHeap.insert('B');
        this.testMinHeap.insert('E');
    }


    @Test 
    public void testInsert(){
        testMinHeap.insert('F');
        testMinHeap.insert('G');
        Assertions.assertEquals("A B C D E F G ", testMinHeap.toString());
    }

    @Test
    void testDelete(){
        testMinHeap.delete();
        Assertions.assertEquals('B', testMinHeap.peek());

        testMinHeap.delete();
        testMinHeap.delete();
        Assertions.assertEquals('D', testMinHeap.peek());

    }

    @Test
    void testPeek(){
        testMinHeap.delete();
        testMinHeap.delete();
        Assertions.assertEquals('C', testMinHeap.peek());

        testMinHeap.insert('D');
        Assertions.assertEquals('C', testMinHeap.peek());
    }

    @Test
    void testSize(){
        Assertions.assertEquals(5, testMinHeap.size());

        testMinHeap.insert('F');
        testMinHeap.insert('G');
        Assertions.assertEquals(7, testMinHeap.size());

        testMinHeap.delete();
        testMinHeap.delete();
        testMinHeap.delete();
        Assertions.assertEquals(4, testMinHeap.size());

    }

    @Test
    void testIsEmpty(){
        testMinHeap.insert('F');
        Assertions.assertFalse(testMinHeap.isEmpty());

        testMinHeap.clear();
        Assertions.assertTrue(testMinHeap.isEmpty());

    }

    @Test
    void testClear(){
        testMinHeap.clear();
        Assertions.assertEquals(0, testMinHeap.size());
    }

    @Test
    void testToString(){
        testMinHeap.insert('F');
        testMinHeap.insert('G');
        Assertions.assertEquals("A B C D E F G ", testMinHeap.toString());

        testMinHeap.delete();
        testMinHeap.delete();
        testMinHeap.delete();
        Assertions.assertEquals("D E F G ", testMinHeap.toString());
    }

}
