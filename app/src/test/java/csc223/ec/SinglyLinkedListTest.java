package csc223.ec;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class SinglyLinkedListTest {

    SinglyLinkedList testList;
    char[] testArray;

    @BeforeEach
    void setup() {
        testList = new SinglyLinkedList();
        testArray = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
    }

    @Test
    // Insert an item at the end of the list for unsorted lists
    void insert() {
        char[] testarray = {'h','i','j','k','l','m','n'};
        for (int i =0;i<testarray.length; i++) {
            testList.insert(testarray[i]);
            assertEquals(testarray[i], testList.getLast());
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
