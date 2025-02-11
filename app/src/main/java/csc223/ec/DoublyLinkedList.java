package csc223.ec;

public class DoublyLinkedList implements LinkedList{

    Node head;
    Node tail;
    int sz;

    public DoublyLinkedList() {
        this.head = new Node();
        this.tail = new Node();

        this.head.next = this.tail;
        this.tail.previous = this.head;

        this.sz = 0;
    }

    // Insert an item at the end of the list for unsorted lists
    public void insert(char item) {
        Node newNode = new Node(this.tail.previous, item, this.tail);
        this.tail.previous.next = newNode;
        this.tail.previous = newNode;
        this.sz++;
    }

    // Removes an item from the list
    public void remove(char item) {
        Node currNode = this.head.next;
        while (currNode.data != item) {
            currNode = currNode.next;
        }

        currNode.next.previous = currNode.previous;
        currNode.previous.next = currNode.next;

        this.sz--;
    }

    // Get the first item, return '☠' if the list is empty
    public char getFirst() {
        if (this.isEmpty()) {
            return '☠';
        }

        return this.head.next.data;
    }

    // Get the last item, return '☠' if the list is empty
    public char getLast() {
        if (this.isEmpty()) {
            return '☠';
        }

        return this.tail.previous.data;
    }

    // Get an item at a specific index, return '☠' if index is out of bounds
    public char get(int index) {
        if (this.isEmpty()) {
            return '☠';
        }

        Node currNode = this.head.next;
        int count = 0;
        while(count != index && currNode != this.tail) {
            currNode = currNode.next;
            count++;
        }

        return currNode.data;
    }

    // Get the size of the list
    public int size() {
        return this.sz;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return this.head.next == this.tail;
    }

    // Clear the list
    public void clear() {
        this.head.next = this.tail;
        this.tail.previous = this.head;
    }

    // Check if the list contains an item
    public boolean contains(char item) {
        Node curr_node = this.head;
        while (curr_node.data != item && curr_node != this.tail) {
            curr_node = curr_node.next;
        }

        if (curr_node.data == item) {
            return true;
        }
        else {
            return false;
        }
    }

    // Get the index of an item, if it exists else return -1
    public int indexOf(char item) {
        Node currNode = this.head.next;
        int count = 0;
        while (currNode != this.tail) {
            if (currNode.data == item) {
                return count;
            }
            currNode = currNode.next;
            count++;
        }

        return -1;
    }

    // Get the last index of an item, if it exists else return -1
    public int lastIndexOf(char item) {
        return this.sz-1;
    }

    // Reverse the list
    public void reverse() {
        Node currNode = this.head;
        Node prevNode = null;

        while (currNode != null) {
            prevNode = currNode.previous;
            currNode.previous = currNode.next;
            currNode.next = prevNode;

            currNode = currNode.previous;
        }
        
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;

    }

    // Creates and returns a String representation of the list
    // e.g. `A -> B -> C -> D` should return "ABCD"
    public String toString() {
        String strNodes = new String();

        Node currNode = this.head.next;
        while (currNode.next != this.tail) {
            strNodes += currNode.data + " -> ";
            currNode = currNode.next;
        }

        strNodes += currNode.data;

        return strNodes;
    }
    
}
