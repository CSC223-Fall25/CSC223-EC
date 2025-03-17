package csc223.ec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class testMaxHeap {
    MaxHeap testMaxHeap;

        @BeforeEach
        void setup() {
            this.testMaxHeap = new MaxHeap();
            this.testMaxHeap.insert('A');
            this.testMaxHeap.insert('B');
            this.testMaxHeap.insert('C');
            this.testMaxHeap.insert('D');
            this.testMaxHeap.insert('E');
        }


        @Test
        void testInsert(){
            testMaxHeap.insert('F');
            testMaxHeap.insert('G');
            Assertions.assertEquals("G D F A C B E", testMaxHeap.toString());
        }

        @Test
        void testDelete(){
            testMaxHeap.delete(); //E D C A B -> D C A B
            Assertions.assertEquals('D', testMaxHeap.peek());

            testMaxHeap.delete(); //D C A B -> C A B
            testMaxHeap.delete(); //C A B -> B A
            Assertions.assertEquals('B', testMaxHeap.peek());
        }

        @Test
        void testPeek(){
            testMaxHeap.delete();
            testMaxHeap.delete();
            Assertions.assertEquals('C', testMaxHeap.peek());

            testMaxHeap.insert('F'); //Inserting greater value
            Assertions.assertEquals('F', testMaxHeap.peek());
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
            Assertions.assertEquals("G D F A C B E", testMaxHeap.toString());

            testMaxHeap.delete();
            testMaxHeap.delete();
            testMaxHeap.delete();
            Assertions.assertEquals("C B E A", testMaxHeap.toString());
        }
}