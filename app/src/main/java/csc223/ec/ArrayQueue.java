package csc223.ec;

public class ArrayQueue implements Queue {

    int[] data;
    int topIdx;
    int capacity;

    public ArrayQueue() {
        this.capacity = 10;
        this.data = new int[capacity];
        this.topIdx = 0;
    }

    public void enqueue(int item) {
        //adding new item
        if (this.topIdx >= this.capacity) {
            //If it is greater create a new queue and expand capacity

            this.capacity += 10;

            int[] newData = new int[this.capacity];
            
            for (int i = 0; i<this.data.length; i++) {
                newData[i] = this.data[i];
            }

            this.data = newData;

            // then add
        }

        this.data[topIdx] = item;
        this.topIdx++;

    }

    public int dequeue() {
        //removing from queue
        int firstElement = this.data[0];

        for (int i=0;i<this.data.length-1; i++) {
            this.data[i] = this.data[i+1];
        }

        topIdx--;

        return firstElement;
    }

    public int peek() {
        //return the first value
        return this.data[0];
    }


    public boolean isEmpty() {
        return this.topIdx == 0;
    }

    public int size() {
        if (this.isEmpty()) {
            return 0;
        }
        
        else {
            return this.topIdx;
        }
    }
}
