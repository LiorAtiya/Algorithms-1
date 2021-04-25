package Algoritems;

import java.util.Arrays;

public class OneSquare {
    public static int oneSquare(int[][] matrix) {

        int[][] help = new int[matrix.length][matrix.length];

        for(int i=0 ; i < matrix.length ; i++){
            help[i][0] = matrix[i][0];
            help[0][i] = matrix[0][i];
        }

        int largestSquare = 0;
        for (int i = 1; i < help.length; i++) {
            for (int j = 1; j < help[0].length; j++) {
                if (matrix[i][j] == 0) help[i][j] = 0;
                else {
                    int min = Math.min(help[i][j-1],help[i-1][j]);
                    min = Math.min(min,help[i-1][j-1]) + 1;
                    help[i][j] = min;
                    if (min > largestSquare) largestSquare = min;
                }
            }
        }

        for(int i=0 ; i < help.length ; i++){
            System.out.println(Arrays.toString(help[i]));
        }
        return largestSquare;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 0, 0, 0},
                          {1, 1, 1, 1, 0},
                          {0, 1, 1, 1, 0},
                          {1, 1, 1, 1, 0},
                          {0, 0, 0, 0, 0}};
        oneSquare(matrix);
        System.out.println(oneSquare(matrix));
    }
}
