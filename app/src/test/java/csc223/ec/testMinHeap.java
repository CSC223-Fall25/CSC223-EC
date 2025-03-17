package csc223.ec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.common.annotations.VisibleForTesting;


public class testMinHeap {
    Heap testMinHeap;

    public testMinHeap(){

        @BeforeEach
        void setup() {
            this.testMinHeap = new testMinHeap('A');
            this.testMinHeap.insert('B');
            this.testMinHeap.insert('C');
            this.testMinHeap.insert('D');
            this.testMinHeap.insert('E');
        }


        @Test
        void testInsert(){
            testMinHeap.insert('F');
            testMinHeap.insert('G');
            Assertions.assertEquals("G F E D C B A", testMinHeap.toString());
        }

        @Test
        void testDelete(){
            testMinHeap.delete();
            Assertions.assertEquals('D', testMinHeap.peek());

            testMinHeap.delete();
            testMinHeap.delete();
            Assertions.assertEquals('B', testMinHeap.peek());

        }

        @Test
        void testPeek(){
            testMinHeap.delete();
            testMinHeap.delete();
            Assertions.assertEquals('C', testMinHeap.peek());

            testMinHeap.insert('D');
            Assertions.assertEquals('D', testMinHeap.peek());
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
            Assertions.assertEquals("G F E D C B A", testMinHeap.toString());

            testMinHeap.delete();
            testMinHeap.delete();
            testMinHeap.delete();
            Assertions.assertEquals("D C B A", testMinHeap.toString());
        }

    }
}
