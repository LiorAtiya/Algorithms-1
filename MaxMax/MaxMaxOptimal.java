package Algoritems.MaxMax;

import java.util.Stack;

public class MaxMaxOptimal {
    private static class Node {
        public int number;
        public Stack<Integer> secondMax = new Stack<>();

        public Node(int number){
            this.number = number;
        }
    }
    //O(n-1+log2n) = O(log2n)
    public static int maxMax4(Node arr[], int low, int high){
        if(low < high){
            int index = 0;
            int middle = (low + high)/2;
            int i = maxMax4(arr,low,middle);
            int j = maxMax4(arr,middle+1, high);

            if(arr[i].number > arr[j].number){
                arr[i].secondMax.push(arr[j].number);
                index = i;
            }else{
                arr[j].secondMax.push(arr[i].number);
                index = j;
            }
            return index;
        }else{
            return low;
        }
    }

    public static void MaxMax4(int[] arr){
        Node[] a = new Node[arr.length];

        for(int i=0 ; i < a.length ; i++){
            a[i] = new Node(arr[i]);
        }

        int index = maxMax4(a,0,a.length-1);
        int max2 = a[index].secondMax.pop();

        while(!a[index].secondMax.isEmpty()){
            int temp = a[index].secondMax.pop();
            if(temp > max2){
                max2 = temp;
            }
        }

        System.out.println("Max1 is: "+a[index].number+", Max2 is: "+max2);
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6};
        MaxMax4(arr);
    }
}
