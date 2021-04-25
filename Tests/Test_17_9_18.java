package Algoritems.Tests;

import java.util.ArrayList;

public class Test_17_9_18 {
    public static void Q1_B(int[] arr, int k){
        ArrayList<Integer> sequence = new ArrayList<>();
        int i = 0; int j=0;
        while(i < arr.length){
            if(sequence.isEmpty()){
                j = i+1;
            }
            while(j < arr.length){
                if(sequence.isEmpty()){
                    if(Math.abs(arr[i]-arr[j]) == k){
                        sequence.add(arr[i]);
                        sequence.add(arr[j]);
                        i = j;
                        j = arr.length;
                    }
                    j++;
                }
            }
            if(!sequence.isEmpty()) {
                if (Math.abs(arr[i] - sequence.get(sequence.size()-1)) == k) {
                    sequence.add(arr[i]);
                }
            }
            i++;
        }

        System.out.println(sequence);
    }

    public static void main(String[] args){
        int arr[] = {1,11,2,10,4,5,2,1}; // output = 2 4 2
        int arr2[] = {10,7,5,4,3,4,1,2,4,7}; //output = 10 7 4 1 4 7
        Q1_B(arr,2);
        Q1_B(arr2,3);

    }
}
