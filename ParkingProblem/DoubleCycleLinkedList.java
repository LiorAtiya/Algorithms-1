package Algoritems.ParkingProblem;

public class DoubleCycleLinkedList {

        private Node head;
        private Node tail;
        private int size;

        //****************************************************
        public DoubleCycleLinkedList() { // Constructor : Build empty list
            head = tail = null;
            size = 0;
        }

        public void add(char data) {
            if (head == null) { // list is empty - add first node
                head = new Node(data,null,null);
                tail = head;
                head.setNext(tail);
                head.setNext(tail);
            } else { // list is not empty - add next node
                Node n = new Node(data, tail, head);
                tail.setNext(n);
                tail = n;
                head.setPrev(tail);
            }
            size++;
        }

        public Node getHead(){
            return this.head;
        }

    public String toString() {
        String s = "[";
        if (head != null){
            s = s + head.toString() + ", ";
            for (Node n = head.getNext(); n != head; n=n.getNext()){
                s = s + n.toString() + ", ";
            }
            s = s.substring(0, s.length()-2);
        }
        return s+"]";
    }

        public int getSize() {
            return size;
        }

    public DoubleCycleLinkedList buildLinkedList() {
        DoubleCycleLinkedList DCLL = new DoubleCycleLinkedList();
        DCLL.add('V');
        DCLL.add('B');
        DCLL.add('M');
        DCLL.add('V');
        DCLL.add('S');
        DCLL.add('A');
        DCLL.add('X');
        DCLL.add('P');
        DCLL.add('V');
        DCLL.add('T');
        System.out.println("DCLL : " + DCLL.toString());
        return DCLL;
    }
    public static void main(String[] args) {
        DoubleCycleLinkedList parking = new DoubleCycleLinkedList(); // parking place DCLL
        parking.buildLinkedList();
    }
}

