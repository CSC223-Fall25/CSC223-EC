package csc223.ec;

public class Node {
    Node next = null;
    Node previous = null;
    char data;

    public Node (Node previous, char item, Node next) {
        this.next = next;
        this.previous = previous;
        this.data = item;
    }

    public Node (char item, Node next) {
        this.next = next;
        this.data = item;
        this.previous = null;
    }

    public Node (char item) {
        this.next = null;
        this.data = item;
        this.previous = null;
    }

    public Node () {
        this.next = null;
        this.previous = null;
        this.data = ' ';
    }

}
