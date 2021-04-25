package Algoritems.TortoiseAndHare;

public class Node1 {
        private int data;
        private Node1 next;

        public Node1(int d) {
            data = d;
            next = null;
        }
        public void setNext(Node1 n) {
            this.next = n;
        }
        public Node1 getNext() {
            return this.next;
        }

        public int getData() {
            return this.data;
        }
        public String toString() {
            return "" + this.data;
        }
}
