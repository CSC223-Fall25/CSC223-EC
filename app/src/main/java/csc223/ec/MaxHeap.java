package csc223.ec;

import java.util.Set;

public class MaxHeap implements Heap{

    char[] heap;
    int size;
    int maxCapacity;

    public MaxHeap() {
        this.heap = new char[size];
        this.size = 0;
        this.maxCapacity = 10;
    }

    // Insert an item to the heap
    public void insert(char value) {
        //check if size meets max capacity
        if (this.size == this.maxCapacity) {
            this.maxCapacity = this.maxCapacity * 2;
            char[] newHeap = new char[this.maxCapacity];
            for (int i=0;i<this.heap.length;i++) {
                newHeap[i] = this.heap[i];
            }
            this.heap = newHeap;
        }

        //add to end of array
        this.heap[this.size] = value;

        //bubble up
        int parentIdx = (int) Math.floor((this.size -1)/2);
        while (this.heap[this.size] > this.heap[parentIdx]) {
            char temp = this.heap[parentIdx];
            this.heap[parentIdx] = this.heap[size];
            this.heap[size] = temp;
        }

        this.size++; //increase size
    }

    // Delete the root element from the heap
    public void delete() {
        //swap first and last node
        char temp = this.heap[0];
        this.heap[0] = this.heap[this.size-1];
        this.heap[this.size-1] = temp;

        //delete last node
        this.heap[this.size-1] = ' ';

        //bubble down
        // Set current position to 0 (the root).
        // Compare the element at current position with its children.
        // Swap the element with the larger of its children.
        // The new current position is the index of the child that the element was swapped with.
        // Repeat steps 1 and 2 until
        // the heap property is satisfied:

        // OR

        // until the element reaches the last level.
    }

    // Get the root element of the heap
    public char peek() {}

    // Get the size of the heap
    public int size() {}

    // Check if the heap is empty
    public boolean isEmpty() {}

    // Clear the heap
    public void clear() {}

    // Return a string representation of all elements in the heap
    public String toString() {}
}
