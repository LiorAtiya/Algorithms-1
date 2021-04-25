package Algoritems.MinMax;

import java.util.Random;

public class minMax {
    public static int[] minmax2(int[] arr){
        int max = arr[0],min = arr[0];
        int[] maxmin = new int[3];
        int counter=0;

        for(int i=1 ; i < arr.length ; i++){
            if(arr[i] < min){
                min = arr[i];
                counter++;
            }else if(arr[i] > max){
                max = arr[i];
                counter +=2;
            }else{
                counter +=2;
            }
        }
        maxmin[0] = min;
        maxmin[1] = max;
        maxmin[2] = counter;
        return maxmin;
    }

    public static int[] minmax4(int[] arr){

        int min,max;
        int counter = 0;
        if(arr[0] < arr[1]) {
            min = arr[0];
            max = arr[1];
        }else{
            min = arr[1];
            max = arr[0];
        }
        counter++;

        int minmax[] = new int[3];

        for(int i=2 ; i < arr.length-1 ; i += 2){
            if(arr[i] < arr[i+1]){
                if(arr[i] < min) min = arr[i];
                if(arr[i+1] > max) max = arr[i+1];
            }else{
                if(arr[i+1] < min) min = arr[i+1];
                if(arr[i] > max) max = arr[i];
            }
            counter += 3;
        }
        if(arr.length % 2 != 0){
            if(arr[arr.length-1] < min) min = arr[arr.length-1];
            else if(arr[arr.length-1] > max) max = arr[arr.length-1];
            counter++;
        }

        minmax[0] = min;
        minmax[1] = max;
        minmax[2] = counter;

        return minmax;
    }

    public static int[] randomArr(){
        Random rnd = new Random();
        int[] arr = new int[1000];
        for(int i=0 ; i < arr.length ; i++){
            int num = rnd.nextInt(1000);
            arr[i] = num;
        }
        return arr;
    }

    public static void test1(){
        int avg2 = 0;
        int avg4 = 0;
        for(int i=0 ; i < 1000 ; i++){
            int[] rndArr = randomArr();
            avg2 += minmax2(rndArr)[2];
            avg4 += minmax4(rndArr)[2];
        }

        System.out.println("Average 2: "+avg2/1000);
        System.out.println("Average 4: "+avg4/1000);
    }

    public static void main(String[] args){
        test1();
    }

}
