package csc223.ec;

public class SinglyLinkedList implements LinkedList {

    Node head;
    int sz;

    public SinglyLinkedList() {
        this.head = new Node();
        this.sz = 0;
    }

    // Insert an item at the end of the list for unsorted lists
    public void insert(char item) {
        Node curr_node = this.head;
        while (curr_node.next != null) {
            curr_node = curr_node.next;
        }
        
        Node newNode = new Node(item);
        curr_node.next = newNode;
        this.sz++;
    }

    // Removes an item from the list
    public void remove(char item) {
        Node curr_node = this.head;
        while (curr_node.next.data != item) {
            curr_node = curr_node.next;
        }

        curr_node.next = curr_node.next.next;

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

        Node curr_node = this.head;
        while (curr_node.next != null) {
            curr_node = curr_node.next;
        }

        return curr_node.data;
    }

    // Get an item at a specific index, return '☠' if index is out of bounds
    public char get(int index) {
        if (index < 0 || index > this.sz-1) {
            return '☠';
        }

        Node curr_node = this.head.next;
        int count = 0;
        while (count != index) {
            curr_node = curr_node.next;
            count++;
        }

        return curr_node.data;
    }

    // Get the size of the list
    public int size() {
        return this.sz;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return this.head.next == null;
    }

    // Clear the list
    public void clear() {
        this.head.next = null;
    }

    // Check if the list contains an item
    public boolean contains(char item) {
        Node curr_node = this.head;
        while (curr_node.data != item && curr_node.next != null) {
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
        int count = 0;
        Node curr_node = this.head.next;
        while (curr_node.data != item && curr_node.next != null) {
            curr_node = curr_node.next;
            count++;
        }

        if (curr_node.data == item) {
            return count;
        }
        else {
            return -1;
        }
    }

    // Get the last index of an item, if it exists else return -1
    public int lastIndexOf(char item) {
        int foundIdx = 0;
        int count = 0;
        Node currNode = this.head;

        while (currNode.next != null) {
            if (currNode.data == item) {
                foundIdx = count;
            }
            currNode = currNode.next;
            count++;
        }

        return foundIdx;
    }

    // Reverse the list
    public void reverse() {
        //three pointers
        Node currNode = this.head.next;
        Node nextNode = currNode.next;
        Node prevNode = null;

        while (currNode != null) {
            nextNode = currNode.next;

            currNode.next = prevNode;

            prevNode = currNode;

            currNode = nextNode;
        }

        this.head.next = prevNode;


        
    }

    // Creates and returns a String representation of the list
    // e.g. `A -> B -> C -> D` should return "ABCD"
    public String toString() {
        String strNodes = new String();

        Node currNode = this.head.next;
        while (currNode.next != null) {
            strNodes += currNode.data + " -> ";
            currNode = currNode.next;
        }

        strNodes += currNode.data;

        return strNodes;
    }
}
