package csc223.ec;

public class SortedLinkedList extends DoublyLinkedList{

    public SortedLinkedList() {
        super();
    }

    // Insert an item at the end if it is greater than the last item or empty list, otherwise find place and put
    public void insert(char item) {
        Node newNode = new Node(item);
        if (this.isEmpty() || item > this.getLast()) {
            super.insert(item);
        }

        else {
            Node currNode = this.head.next;
            while (currNode.data < item) {
                currNode = currNode.next;
            }

            newNode.next = currNode;
            newNode.previous = currNode.previous;

            currNode.previous = newNode;
            newNode.previous.next = newNode;

            this.sz++;
        }

    }

    // Removes an item from the list
    public void remove(char item) {
        super.remove(item);
    }

    // Get the first item, return '☠' if the list is empty
    public char getFirst() {
        return super.getFirst();
    }

    // Get the last item, return '☠' if the list is empty
    public char getLast() {
        return super.getLast();
    }

    // Get an item at a specific index, return '☠' if index is out of bounds
    public char get(int index) {
        return super.get(index);
    }

    // Get the size of the list
    public int size() {
        return super.size();
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return super.isEmpty();
    }

    // Clear the list
    public void clear() {
        super.clear();
    }

    // Check if the list contains an item
    public boolean contains(char item) {
        return super.contains(item);
    }

    // Get the index of an item, if it exists else return -1
    public int indexOf(char item) {
        return super.indexOf(item);
    }

    // Get the last index of an item, if it exists else return -1
    public int lastIndexOf(char item) {
        return super.lastIndexOf(item);
    }

    // Reverse the list
    public void reverse() {
        super.reverse();
    }

    // Creates and returns a String representation of the list
    // e.g. `A -> B -> C -> D` should return "ABCD"
    public String toString() {
        return super.toString();
    }

}
