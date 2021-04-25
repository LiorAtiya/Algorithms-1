package Algoritems.Tests;

public class CircleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public CircleLinkedList() { // Constructor : Build empty list
        head = null;
        tail = null;
        size = 0;
    }

    public Node getHead() {
        return this.head;
    }

    public void add(int n) {
        if (head == null) { // list is empty - add first node
            head = new Node(n);
            tail = head;
        } else { // list is not empty - add next node
            Node oldTail = tail;
            tail = new Node(n);
            oldTail.setNext(tail);
        }
        size++;
    }


    public void addLoop(int index) { // index - first loop's node
        Node current = head;
        while (current.getData() != index) {
            if (current.getNext() == null)
                return;
            current = current.getNext();
        }
        tail.setNext(current);
    }

    public String toString() {
        Node current = head;
        String result = "";
        int count = 0;
        while (current != null) {
            result += "[" + current.getData() + "]";
            current = current.getNext();
            count++;
            if (count % 10 == 0 || count % 16 == 0)
                result = result + " ";
            if (count == 20) // maybe linked list has a loop
                break;
        }
        return result;
    }
}
