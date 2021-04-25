package Algoritems.GameOfNumbers;

public class GameOfNumbersOptimal {

    //O(n^2/2) = O(n/2)
    public static int[][] buildMatrix(int arr[]){
        int[][] matrix = new int[arr.length][arr.length];

        for(int i=0 ; i < matrix.length ; i++){
            matrix[i][i] = arr[i];
        }

        for(int i = matrix.length-2 ; i > 0 ; i--){
            for (int j= i+1 ; j < matrix[i].length-1 ; j++){
                matrix[i][j] = Math.max(arr[i] - matrix[i+1][j],arr[j] - matrix[i][j-1]);
            }
        }
        return matrix;
    }

    //O(n^2/2 + n^2/2) = O(n^2)
    public static void gameStrategy(int[] game){
        int firstSum,secondSum;
        firstSum=secondSum=0;
        int[][] matrix = buildMatrix(game);

        int i = 0;
        int j = game.length-1;
        for(int k=0 ; k < matrix.length/2 ; k++){
            //The choose of first player
            if(game[i] - matrix[i+1][j] > game[j] - matrix[i][j-1]){
                firstSum += game[i];
                i++;
            }else{
                firstSum += game[j];
                j--;
            }

            if(game[i] - matrix[i+1][j] > game[j] - matrix[i][j-1]){
                secondSum += game[i];
                i++;
            }else{
                secondSum += game[j];
                j--;
            }

        }
        System.out.println("First sum = "+firstSum+", Second sum = "+secondSum);
    }

    public static void main(String[] args){
        int[] arr = {4,1,5,9};
        gameStrategy(arr);
    }
}
