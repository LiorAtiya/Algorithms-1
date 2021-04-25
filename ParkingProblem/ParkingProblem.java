package Algoritems.ParkingProblem;

public class ParkingProblem {

    DoubleCycleLinkedList cars;
    Node currentNode;
    int count = 1;
    char oldSign = 'V';
    char newSign = 'W';
    int steps = 0;

    public ParkingProblem(DoubleCycleLinkedList cars){
        this.cars = cars;
        this.currentNode = cars.getHead().getNext();
    }

    public int CountCars(){
        while(cars.getHead().getData() == oldSign){
            steps++;
            currentNode = currentNode.getNext();
            if(currentNode.getData() == oldSign){
                currentNode.setData(newSign);

                for(int i=0 ; i < steps ; i++){
                    currentNode = currentNode.getPrev();
                }
                count = steps+1;
                steps = 0;
            }
        }

        return count;
    }

    public static void main(String[] args){
        DoubleCycleLinkedList dcl = new DoubleCycleLinkedList();
        dcl.add('V');
        dcl.add('V');
        dcl.add('V');
        dcl.add('V');
        dcl.add('W');
        dcl.add('W');
        dcl.add('W');
        dcl.add('W');

        ParkingProblem pp = new ParkingProblem(dcl);
        System.out.println(pp.cars);
        System.out.println(pp.CountCars());
    }
}
