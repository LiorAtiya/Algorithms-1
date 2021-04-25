package Algoritems.GlassBall;

public class useFloorPotential {
    public static void useFloorPotential(int a,int[] arr){
        int num = 1;
        int numFloors = arr.length;

        while (numFloors > num*(num+1)/2){ //The size of the floors
            num++;
        }

        int jump = num; //Floor that we in
        int step = num-1; //Number of floors raised each time the ball is not broken

        while (arr[jump] < a){ //When the ball will broken
            jump = jump + step;
            step = step-1;
        }

        System.out.println("The first ball breaks at floor "+jump); //The first floor that broken the ball
        int floor = jump - (step + 1); //Go down to the last floor where the ball is not broken and go up one floor at a time and check

        while (arr[floor] < a){
            floor++;
        }

        System.out.println("The second ball is broken at floor number "+floor);//The floor that the ball is broken
    }


    public static void main(String[] args){
        int[] floors = {0,1,2,3,4,5,6,7,8};
        useFloorPotential(6,floors);
    }
}
