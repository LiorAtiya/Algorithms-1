package Algoritems;

public class Median {

    //64 A number large enough for the probability that the Max will be greater than the median
    public static int median(int[] arr){
        int max = arr[0];

        for(int i=1 ; i < arr.length && i < 64-1 ; i += 2){
            if(arr[i] < arr[i+1]) {
                if (max < arr[i+1]) max = arr[i + 1];
            }else if(arr[i] > max) max = arr[i];
        }

        return max;
    }

    public static void main(String[] args){

    }
}
