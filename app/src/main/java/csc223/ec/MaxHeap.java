package csc223.ec;

public class MaxHeap implements Heap{

    char[] heap;
    int size;
    int maxCapacity;

    public MaxHeap() {
        this.size = 0;
        this.maxCapacity = 10;
        this.heap = new char[this.maxCapacity];
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

        this.size++; //increase size

        //bubble up
        int elementIdx = this.size-1;
        while (elementIdx > 0) { //Not if idx = 0
            int parentIdx = (int) Math.floor((elementIdx-1)/2);
            if (this.heap[elementIdx] >= this.heap[parentIdx]) { //If child > parent
                char temp = this.heap[parentIdx];
                this.heap[parentIdx] = this.heap[elementIdx];
                this.heap[elementIdx] = temp;

                elementIdx = parentIdx; //Swap idx
            }
            else {
                return;
            }
        }
    }

    // Delete the root element from the heap
    public void delete() {
        //swap first and last node
        char temp = this.heap[0];
        this.heap[0] = this.heap[this.size-1];
        this.heap[this.size-1] = temp;

        //delete last node
        this.heap[this.size-1] = ' ';
        this.size--;

        //bubble down
        // Set current position to 0 (the root).
        int currIdx = 0;
        int leftChild = currIdx*2 + 1;
        int rightChild = currIdx*2 + 2;
        while ((leftChild < this.size) && (this.heap[currIdx] < this.heap[leftChild] || this.heap[currIdx] < this.heap[rightChild])) {
            // Compare the element at current position with its children.
            // Swap the element with the larger of its children.
            leftChild = currIdx*2 + 1;
            rightChild = currIdx*2 + 2;
            char newTemp = this.heap[currIdx];
            if (this.heap[leftChild] > this.heap[currIdx]) {
                this.heap[currIdx] = this.heap[leftChild];
                this.heap[leftChild] = newTemp;
                // The new current position is the index of the child that the element was swapped with.
                currIdx = leftChild;
                }
            else {
                if (this.heap[rightChild] > this.heap[currIdx]) {
                    this.heap[currIdx] = this.heap[rightChild];
                    this.heap[rightChild] = newTemp;
                    // The new current position is the index of the child that the element was swapped with.
                    currIdx = rightChild;
                }
            }
        }
        //repeat until heap is satisfied or reaches last level, 2i+1 > size
    }

    // Get the root element of the heap
    public char peek() {
        return this.heap[0];
    }

    // Get the size of the heap
    public int size() {
        return this.size;
    }

    // Check if the heap is empty
    public boolean isEmpty() {
        return this.size == 0;
    }

    // Clear the heap
    public void clear() {
        this.heap = new char[this.maxCapacity];
        this.size = 0;
    }

    // Return a string representation of all elements in the heap
    public String toString() {
        String arrayString = "";
        for (int i =0; i<this.size-1; i++) {
            arrayString += this.heap[i] + " ";
        }
        arrayString += this.heap[this.size-1];
        return arrayString;
    }
}
