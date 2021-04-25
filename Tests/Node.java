package Algoritems.Tests;

public class Node {
    private int data;
    private Node next;

    public Node(int d) {
        data = d;
        next = null;
    }
    public void setNext(Node n) {
        this.next = n;
    }
    public Node getNext() {
        return this.next;
    }

    public int getData() {
        return this.data;
    }
    public String toString() {
        return "" + this.data;
    }
}
