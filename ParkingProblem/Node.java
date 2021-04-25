package Algoritems.ParkingProblem;
public class Node {
    private char data;
    private Node next,prev;

    public Node(char d, Node prev, Node next) {
        data = d;
        this.next = next;
        this.prev = prev;
    }
    public void setNext(Node n) {
        next = n;
    }
    public Node getNext() {
        return this.next;
    }
    public void setPrev(Node n) {
        this.prev = n;
    }
    public Node getPrev() {
        return this.prev;
    }
    public char getData() {
        return data;
    }
    public void setData(char data) {
        this.data = data;
    }
    public String toString() {
        return "" + this.data;
    }
}
