package Algoritems.Tests;

import java.util.ArrayList;
import java.util.Arrays;

public class Test_22_1_18 {

    public static void Q1_B(CircleLinkedList dc, Node first){

//        int size = dc.getSize();
        Node p1 = first.getNext();
        Node p2 = first.getNext().getNext();

        //Meeting on the circle
        while(p1 != p2){
            p1 = p1.getNext();
            p2 = p2.getNext().getNext();
        }

        p1 = first;
        int lineLength = 1;
        while(p1 != p2){
            p1 = p1.getNext();
            p2 = p2.getNext();
            lineLength++;
        }

        int circleLength = 1;
        p2 = p2.getNext();
        while (p1 != p2){
            p2 = p2.getNext();
            circleLength++;
        }

        System.out.println("lineLength: "+lineLength+", circleLength: "+circleLength);
    }

    public static void Q3_B(int[] arr, int choose){

        //Delete int from arr
        int[] newArr = new int[arr.length-1];
        int index = 0;
        for(int i=choose+1 ; i < arr.length ; i++){
            newArr[index++] = arr[i];
        }
        for(int i=0 ; i < choose ; i++){
            newArr[index++] = arr[i];
        }

        System.out.println(Arrays.toString(newArr));

        //Build matrix for game
        int[][] matrix = new int[newArr.length][newArr.length];

        for(int i=0 ; i < matrix.length ; i++){
            matrix[i][i] = arr[i];
        }

        for(int i = matrix.length-2 ; i > 0 ; i--){
            for (int j= i+1 ; j < matrix[i].length-1 ; j++){
                matrix[i][j] = Math.max(arr[i] - matrix[i+1][j],arr[j] - matrix[i][j-1]);
            }
        }

        //Start game
        int firstSum = arr[choose];
        int secondSum = 0;

        int i = 0;
        int j = matrix.length-1;
        for(int k=0 ; k < matrix.length/2 ; k++){
            //The choose of second player
            if(newArr[i] - matrix[i+1][j] > newArr[j] - matrix[i][j-1]){
                secondSum += newArr[i];
                System.out.println("second choice: "+newArr[i]+", "+secondSum);
                i++;
            }else{
                secondSum += newArr[j];
                System.out.println("second choice: "+newArr[j]+", "+secondSum);
                j--;
            }

            if(j > 0){
                if(newArr[i] - matrix[i+1][j] > newArr[j] - matrix[i][j-1]){
                    firstSum += newArr[i];
                    System.out.println("first choice: "+newArr[i]+", "+firstSum);
                    i++;
                }else{
                    firstSum += newArr[j];
                    System.out.println("first choice: "+newArr[j]+", "+firstSum);
                    j--;
                }
            }else{
                firstSum += newArr[j];
                System.out.println("first choice: "+newArr[i]+", "+firstSum);
                j--;
            }
        }

        if(newArr.length % 2 != 0){
            secondSum += newArr[j];
        }

        System.out.println("First sum is "+firstSum+", second sum is "+secondSum);
    }

    public static void Q4(String str){
        ArrayList<String> longest = new ArrayList<>();
        String s = ""+str.charAt(0);
        for(int i=1 ; i < str.length() ; i++){
            if(str.charAt(i) != str.charAt(i-1)){
                if(!s.contains(""+str.charAt(i))){
                    s += str.charAt(i);
                }else{
                    longest.add(s);
                    s = ""+str.charAt(i);
                }
            }else{
                longest.add(s);
                s = ""+str.charAt(i);
            }
        }
        longest.add(s);
        System.out.println(longest);
        String max = longest.get(0);
        for(int i=1 ; i < longest.size() ; i++){
            if(longest.get(i).length() > max.length()){
                max = longest.get(i);
            }
        }

        System.out.println("The longest string is "+max);
    }

    public static void main(String[] args){
//        CircleLinkedList cll = new CircleLinkedList();
//        for(int i = 0 ; i < 10 ; i++){
//            cll.add(i);
//        }
//        cll.addLoop(3);
//        Q1_B(cll, cll.getHead());

//        int[] arr = {10,4,1,5,9};
//        int[] arr1 = {10,4,3,2,8,7};
//        Q3_B(arr1,2);
        Q4("abcabcbb");
        Q4("bbbbbb");
        Q4("pwwkew");
    }

}
