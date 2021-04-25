package Algoritems.Tests;

import java.util.ArrayList;
import java.util.Arrays;

public class Test_3_10_17 {

    public static int Q1_A(int[][] matrix){
        int[][] help = new int[matrix.length][matrix.length];
        int max = 0;
        int numOf2x2 = 0;
        for(int i=0 ; i < matrix.length ; i++){
            help[i][0] = matrix[i][0];
            help[0][i] = matrix[0][i];
        }

        for(int i=1 ; i < matrix.length ; i++){
            for(int j=1 ; j < matrix.length ; j++){
                if(matrix[i][j] == 0) help[i][j] = 0;
                else {
                    help[i][j] = Math.min(Math.min(help[i - 1][j], help[i - 1][j - 1]), help[i][j - 1]) + 1;
                    if (help[i][j] > max) {
                        max = help[i][j];
                    }
                    if(help[i][j] > 1){
                        numOf2x2++;
                    }
                }
            }
        }
        for(int i=0 ; i < help.length ; i++){
            System.out.println(Arrays.toString(help[i]));
        }
        System.out.println("The biggest matrix of 1 is "+max+"x"+max);
        System.out.println("The number of matrix of 2x2 of 1 is "+numOf2x2);

        return max;
    }

    public static void Q2_A(int[] arr){
        int[][] matrix = new int[arr.length][arr.length];
        matrix[0][0] = arr[0];
        int lis = 0;
        int max = arr[arr.length-1];

        for(int i=1 ; i < arr.length ; i++){
            int index = binarySearch(matrix,arr[i], lis);
            for(int j=0 ; j < index ; j++){
                matrix[index][j] = matrix[index-1][j];
            }
            matrix[index][index] = arr[i];
            if(index > lis) lis++;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= lis; i++) {
            ans.add(matrix[lis][i]);
        }

        for(int i=arr.length-1 ; i >= 0 ; i--){
            if(max < arr[i] && arr[i] == ans.get(ans.size()-1)) {
                max = i;
                break;
            }
        }

//        System.out.println(max);
        int k = max;
        int min = 0;

        while(k > 0){
            if(ans.get(0) == arr[k]){
                min = k;
                break;
            }
            k--;
        }
//        System.out.println(min);

        for(int i=0 ; i < min ; i++){
            if(arr[i] > ans.get(ans.size()-1)) ans.add(arr[i]);
        }

        System.out.println(ans);
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

    public static void Q3_A(int num){
        int[][] ans = {{1,1},{1,0}};
        int[][] A = {{1,1},{1,0}};
        int k = num;
        while (num != 0){
            if(num % 2 == 1) ans = MultiplyMatrix(ans,A);
            A = MultiplyMatrix(A,A);
            num = num/2;
        }

        System.out.println("fib("+k+") = "+ans[1][1]);

    }

    private static int[][] MultiplyMatrix(int[][] a, int[][] a1) {
        int[][] ans = new int[a.length][a.length];
        ans[0][0] = (a[0][0] * a1[0][0]) + (a[0][1] * a1[1][0]);
        ans[0][1] = (a[0][0] * a1[0][1]) + (a[0][1] * a1[1][1]);
        ans[1][0] = (a[1][0] * a1[0][0]) + (a[1][1] * a1[1][0]);
        ans[1][1] = (a[1][0] * a1[0][1]) + (a[1][1] * a1[1][1]);
        return ans;
    }

//    public static void Q4_A(String s1,String s2){
//        String st = "";
//
//
//    }

    public static void Q4_A_Option2(String s1 ,String s2){
        int[][] matrix = new int[s2.length()+1][s1.length()+1];
        int max = 0;
        for(int i=1 ; i < matrix.length ; i++){
            for(int j=1 ; j < matrix[0].length ; j++){
                if(s1.charAt(j-1) == s2.charAt(i-1)){
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                    if(matrix[i][j] > max) max = matrix[i][j];
                }else{
                    matrix[i][j] = Math.max(matrix[i-1][j],matrix[i][j-1]);
                }
            }
        }

        int i = matrix.length-1;
        int j = matrix[0].length-1;
        int count = matrix[i][j]-1;
        String common = "";

        while(count >= 0){
            if(s1.charAt(j-1) == s2.charAt(i-1)){
                common = s1.charAt(j-1) + common;
                i--; j--; count--;
            }else if(matrix[i][j] == matrix[i][j-1]){
                j--;
            }else{
                i--;
            }
        }

        String other = "";
        for(int t=0 ; t < s1.length() ; t++){
            if(!common.contains(""+s1.charAt(t))) other += s1.charAt(t);
        }

        System.out.println(other);
    }

    public static void main(String[] args){
//        int[][] matrix = {{0,0,1,0,1},
//                          {0,1,1,1,1},
//                          {1,1,1,1,0},
//                          {0,1,1,1,1},
//                          {0,0,1,1,1}};
//       Q1_A(matrix);

//       int[] arr = {9,10,8,0,1,4,3,7};
//       int[] arr2 = {1,11,2,10,4,5,2,1};
//       int[] arr3 = {2,3,1};
//       Q2_A(arr3);

//        Q3_A(8);


//        Q4_A("abcbdab","bdcaba");
        Q4_A_Option2("kbbbc","abba");
        Q4_A_Option2("abba","kbbbc");
        Q4_A_Option2("ag","abcd");
    }
}
