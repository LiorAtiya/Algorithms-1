package Algoritems.LIS;

import java.util.Arrays;

public class DynamicLIS {
    //O(nlog2n)
    public static void LISLength(int[] arr){
        int[] list = new int[arr.length];
        int lis = 0;
        for(int i=0 ; i < arr.length ; i++){
            int index = binarySearch(list, arr[i], lis);
            list[index] = arr[i];
            if(index > lis) lis++;
        }
        System.out.println(lis);
    }

    public static int binarySearch(int[] arr, int num,int lis){
        if (num < arr[0]) return 0;
        if (num > arr[lis]) return lis+1;

        int start = 0;
        while (start <= lis){
            if(start == lis) return start;
            else {
                int middle = (start + lis) / 2;
                if (arr[middle] == num) return middle;
                if (num < arr[middle]) lis = middle;
                else start = middle + 1;
            }

        }
        return -1;
    }


    //O(n*(n+log2n)) = O(n^2)
    public static int[] LISLongestString(int[] arr) {
        int matrix[][] = new int[arr.length][arr.length];
        matrix[0][0] = arr[0];
        int lengthList = 0;

        for (int i = 1; i < arr.length; i++) {
            //Find the place of arr[i] in diagonal
            int index = binarySearch(matrix, arr[i], lengthList);
            //Copy the line above to this line
            for (int j = 0; j < index; j++) {
                matrix[index][j] = matrix[index - 1][j];
            }
            //Put the arr[i] in the place
            matrix[index][index] = arr[i];
            if (index > lengthList) lengthList++;
        }
        int[] ans = new int[lengthList+1];
        //The last line is the answer
        for (int i = 0; i <= lengthList; i++) {
//            System.out.print(matrix[lengthList][i] + " ");
            ans[i] = matrix[lengthList][i];
        }
//        System.out.println();
//        for(int i=0 ; i < matrix.length ; i++){
//            System.out.println(Arrays.toString(matrix[i]));
//        }
        return ans;
    }

    public static int[] reverse(int[] arr){
        int[] rev = new int[arr.length];
        int index = 0;
        for(int i=arr.length-1 ; i >= 0 ; i--){
            rev[index++] = arr[i];
        }
        return rev;
    }

    //O(2n+n^2) = O(n^2)
    public static int[] LDSLongestString(int[] arr){
        int[] ans = LISLongestString(reverse(arr));
        return reverse(ans);
    }

    public static int binarySearch(int[][] arr, int num,int lis){
        if (num < arr[0][0]) return 0;
        if (num > arr[lis][lis]) return lis+1;

        int start = 0;
        int end = lis;
        while (start <= end){
            if(start == end) return start;
            int middle = (start + end)/2;

            if(arr[middle][middle] == num) return middle;
            if(num < arr[middle][middle]) end = middle;
            else start = middle+1;

        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {8,4,12,2,3,10,14};
//        int[] arr = {5,9,4,20,6,3,7,8,11};
        LISLength(arr);
        System.out.println(Arrays.toString(LISLongestString(arr)));
        System.out.println(Arrays.toString(LDSLongestString(arr)));
    }
}
