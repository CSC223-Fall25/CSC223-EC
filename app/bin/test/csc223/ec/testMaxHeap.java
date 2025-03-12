package csc223.ec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.common.annotations.VisibleForTesting;


public class testMaxHeap {
    Heap testMaxHeap;

    public testMaxHeap(){

        @BeforeEach
        void setup() {
            this.testMaxHeap = new testMaxHeap('A');
            this.testMaxHeap.insert('B');
            this.testMaxHeap.insert('C');
            this.testMaxHeap.insert('D');
            this.testMaxHeap.insert('E');
        }


        @Test
        void testInsert(){
            testMaxHeap.insert('F');
            testMaxHeap.insert('G');
            Assertions.assertEquals("A B C D E F G", testMaxHeap.toString());
        }

        @Test
        void testDelete(){
            testMaxHeap.delete();
            Assertions.assertEquals('B', testMaxHeap.peek());

            testMaxHeap.delete();
            testMaxHeap.delete();
            Assertions.assertEquals('D', testMaxHeap.peek());

        }

        @Test
        void testPeek(){
            testMaxHeap.delete();
            testMaxHeap.delete();
            Assertions.assertEquals('C', testMaxHeap.peek());

            testMaxHeap.insert('B');
            Assertions.assertEquals('B', testMaxHeap.peek());
        }

        @Test
        void testSize(){
            Assertions.assertEquals(5, testMaxHeap.size());

            testMaxHeap.insert('F');
            testMaxHeap.insert('G');
            Assertions.assertEquals(7, testMaxHeap.size());

            testMaxHeap.delete();
            testMaxHeap.delete();
            testMaxHeap.delete();
            Assertions.assertEquals(4, testMaxHeap.size());

        }

        @Test
        void testIsEmpty(){
            testMaxHeap.insert('F');
            Assertions.assertFalse(testMaxHeap.isEmpty());

            testMaxHeap.clear();
            Assertions.assertTrue(testMaxHeap.isEmpty());

        }

        @Test
        void testClear(){
            testMaxHeap.clear();
            Assertions.assertEquals(0, testMaxHeap.size());


        }

        @Test
        void testToString(){
            testMaxHeap.insert('F');
            testMaxHeap.insert('G');
            Assertions.assertEquals("A B C D E F G", testMaxHeap.toString());

            testMaxHeap.delete();
            testMaxHeap.delete();
            testMaxHeap.delete();
            Assertions.assertEquals("D E F G", testMaxHeap.toString());
        }

    }
}
