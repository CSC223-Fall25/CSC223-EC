package csc223.ec;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortedLinkedListTest {
    DoublyLinkedList testList;
    char[] testArray;

    @BeforeEach
    void setup() {
        testList = new SortedLinkedList();
        testArray = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
    }

    @Test
    // Insert an item at the end of the list for unsorted lists
    void insert() {
        for (int i =0;i<testArray.length; i++) {
            testList.insert(testArray[i]);
            assertEquals(testArray[i], testList.getLast());
        }

        testList.clear();
        testArray = new char[]{'6', '5', '4', '3', '2', '1'};
        for (int i =0;i<testArray.length; i++) {
            testList.insert(testArray[i]);
        }

        System.out.println(testList.toString());

        char[] correctList = new char[]{'1', '2', '3', '4', '5', '6'};

        for (int i =0;i<testArray.length; i++) {
            assertEquals(correctList[i], testList.get(i));
        }        
    }

    // Removes an item from the list
    @Test
    public void remove() {
        testList.insert('a');
        testList.remove('a');
        assertEquals(false,testList.contains('a'));

        for (int i=0; i<testArray.length; i++) {
            testList.insert(testArray[i]);
        }

        for (int i=0; i<testArray.length; i++) {
            testList.remove(testArray[i]);
            assertEquals(false, testList.contains(testArray[i]));
        }        
    }

    // Get the first item, return '☠' if the list is empty
    @Test
    public void getFirst() {
        testList.insert('a');
        assertEquals('a', testList.getFirst()); 
    }

    // Get the last item, return '☠' if the list is empty
    @Test
    public void getLast() {
        testList.insert('a');
        testList.insert('b');

        assertEquals('b', testList.getLast());
    }

    // Get an item at a specific index, return '☠' if index is out of bounds
    @Test
    public void get() {
        testList.insert('a');
        assertEquals('a', testList.get(0));
    }

    // Get the size of the list
    @Test
    public void size() {
        testList.insert('a');
        testList.insert('a');
        testList.insert('a');

        assertEquals(3, testList.size());
    }

    // Check if the list is empty
    @Test
    public void isEmpty() {
        SinglyLinkedList emptyList = new SinglyLinkedList();
        assertEquals(true, emptyList.isEmpty());
    }

    // Clear the list
    @Test
    public void clear() {
        testList.insert('a');
        testList.clear();
        assertEquals(true, testList.isEmpty());
    }

    // Check if the list contains an item
    @Test
    public void contains() {
        testList.insert('a');
        assertEquals(true,testList.contains('a'));
    }

    // Get the index of an item, if it exists else return -1
    @Test
    public void indexOf() {
        testList.insert('a');
        assertEquals(0, testList.indexOf('a'));
    }

    // Get the last index of an item, if it exists else return -1
    @Test
    public void lastIndexOf() {
        testList.insert('a');
        testList.insert('a');
        testList.insert('a');
        assertEquals(2, testList.lastIndexOf('a'));
    }

    // Reverse the list
    @Test
    public void reverse() {
        for (int i = 0; i< testArray.length; i++) {
            testList.insert(testArray[i]);
        }

        char[] reversedList = {'f','e','d','c','b','a'};
        testList.reverse();
        for (int i = 0; i<reversedList.length; i++) {
            assertEquals(reversedList[i],testList.get(i));
        }
    }

    // Creates and returns a String representation of the list
    // e.g. `A -> B -> C -> D` should return "ABCD"
    @Test
    public void toStringTest() {
        for (int i = 0; i< testArray.length; i++) {
            testList.insert(testArray[i]);
        }

        String testString = "a -> b -> c -> d -> e -> f";
        assertEquals(testString, testList.toString());
    }
}
