package Algoritems.MaxMax;

public class maxMax {
    public static int[] maxMax(int[] arr){
        int max1,max2,count = 0;
        if(arr[0] > arr[1]){
            max1 = arr[0];
            max2 = arr[1];
        }else{
            max1 = arr[1];
            max2 = arr[0];
        }

        for(int i=2 ; i < arr.length-1 ; i+=2){
            if(arr[i] > arr[i+1]) {
                if(arr[i] > max1) max1 = arr[i];
                if(arr[i + 1] > max2) max2 = arr[i + 1];
            }else{
                if(arr[i+1] > max1) max1 = arr[i+1];
                if(arr[i] > max2) max2 = arr[i];
            }
            count += 3;
        }

        System.out.printf("Max1 is: %d\n", max1);
        System.out.printf("Max2 is: %d\n", max2);
        System.out.printf("Count: %d", count);

        return null;
    }

    public static int[] maxMax4(int[] arr){

        int max1,max2,count = 0;
        if(arr[0] > arr[1]){
            max1 = arr[0];
            max2 = arr[1];
        }else{
            max1 = arr[1];
            max2 = arr[0];
        }

        for(int i=2 ; i < arr.length-1 ; i+=2){
            if(arr[i] > arr[i+1]) {
                if(arr[i] > max1) max1 = arr[i];
                if(arr[i + 1] > max2) max2 = arr[i + 1];
            }else{
                if(arr[i+1] > max1) max1 = arr[i+1];
                if(arr[i] > max2) max2 = arr[i];
            }
            count += 3;
        }

        return null;
    }




    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6};
        int[] arr2 = {6,5,4,3,2,1};
        int[] arr3 = {4,4,4,4,4,4,4};

        maxMax(arr);
    }
}
