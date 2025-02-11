package csc223.ec;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {
    
    @Test
    public void testEnqueue() {
        ArrayQueue testArrays = new ArrayQueue();
        testArrays.enqueue(1);
        testArrays.enqueue(2);
        testArrays.enqueue(3);
        assertEquals(1, testArrays.peek());
        
        //add until new array needs to be created
        for (int i = 4; i<50; i++) {
            testArrays.enqueue(i);
        }

        //test for it
        for (int i = 1; i<50; i++) {
            assertEquals(i, testArrays.dequeue());
        }
    }

    // ArrayQueue testArray;

    // @BeforeEach
    // public void setup() {
    //     ArrayQueue testArray = new ArrayQueue();
    //     testArray.enqueue(1);
    //     testArray.enqueue(2);
    //     testArray.enqueue(3);
    //     testArray.enqueue(4);
    //     testArray.enqueue(5);
    // }

    @Test
    public void testDequeue() {
        ArrayQueue testArray = new ArrayQueue();
        testArray.enqueue(1);
        testArray.enqueue(2);
        testArray.enqueue(3);
        testArray.enqueue(4);
        testArray.enqueue(5);
        assertEquals(1, testArray.dequeue());
        assertEquals(2, testArray.dequeue());
        assertEquals(3, testArray.dequeue());
        assertEquals(4, testArray.dequeue());
        assertEquals(5, testArray.dequeue());
    }


    @Test
    public void testPeek() {
        ArrayQueue testArray = new ArrayQueue();
        testArray.enqueue(1);
        testArray.enqueue(2);
        testArray.enqueue(3);
        assertEquals(1, testArray.peek());
    }

    @Test
    public void testIsEmpty() {
        ArrayQueue emptyArray = new ArrayQueue();
        assertEquals(true, emptyArray.isEmpty());
    }

    @Test
    public void testSize() {
        ArrayQueue testArray = new ArrayQueue();

        assertEquals(0, testArray.size());

        testArray.enqueue(1);
        testArray.enqueue(2);
        testArray.enqueue(3);
        assertEquals(3, testArray.size());
    }

}
