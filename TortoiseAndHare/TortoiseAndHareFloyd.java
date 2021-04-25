package Algoritems.TortoiseAndHare;

public class TortoiseAndHareFloyd {

//    Node1 slow;
//    Node1 fast;
    CircleLinkedList dc;

    public TortoiseAndHareFloyd(CircleLinkedList dc){
        this.dc = dc;
//        this.slow = dc.;

    }

    //To verify the existence of the cycle (loop).
    public boolean hasCircle(Node1 first){
//        //Option 1
//        Node1 fast ,slow;
//        fast = slow = first;
//
//        while(true){
//            if(slow.getNext() == null) return false;
//            if(fast.getNext() == null) return false;
//
//            slow = slow.getNext();
//            fast = fast.getNext().getNext();
//
//            if(slow == null || fast == null) return false;
//            if(slow.equals(fast)) return true;
//        }

        ////Option 2
        int size = dc.getSize();
        Node1 temp = first;

        for(int i=1 ; i < size ; i++){
            if(first.getNext() == null) return false;
            first = first.getNext();
        }

        for(int i=1 ; i < size-1 ; i++){
            if(temp.equals(first.getNext())) return true;
            temp = temp.getNext();
        }

        return false;

    }

    //To find the meeting point.
    public Node1 meetingPoint(Node1 first){
        Node1 slow;
        Node1 fast;
        slow = fast = first;

        while(true){
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if(slow.equals(fast)) return slow;
        }
    }

    //To find the cycle (loop) starting point.
    public Node1 startCircle(Node1 first){
        Node1 slow = first;
        Node1 fast = meetingPoint(first);

        while(true){
            slow = slow.getNext();
            fast = fast.getNext();

            if(slow == fast) return slow;
        }

    }

    //To find the length of the cycle (loop).
    public int lengthCircle(){
        Node1 first = this.dc.getHead();
        Node1 start = startCircle(first);
        Node1 temp = start;
        int count=1;

        while(start.getNext() != temp){
            count++;
            start = start.getNext();
        }
        return count;
    }

    public static void main(String[] args){
        CircleLinkedList cl1 = new CircleLinkedList();
        for(int i = 0 ; i < 5 ; i++){
            cl1.add(i);
        }

        cl1.addLoop(2);
        System.out.println(cl1);

        TortoiseAndHareFloyd test1 = new TortoiseAndHareFloyd(cl1);
        boolean ans = test1.hasCircle(cl1.getHead());
        System.out.println("hasCircle: "+ans);

        Node1 ans1 = test1.meetingPoint(cl1.getHead());
        System.out.println("meetingPoint: "+ans1.getData());

        Node1 ans2 = test1.startCircle(cl1.getHead());
        System.out.println("startCircle: "+ans2.getData());

        int ans3 = test1.lengthCircle();
        System.out.println("lengthCircle: "+ans3);
    }
}
