package Algoritems.AirplaneProblem;

import Algoritems.Tests.Test_31_10_17;

import java.util.ArrayList;
import java.util.Scanner;

public class PlaneProblem {
    static class Node {
        int value;
        int down;
        int right;
        int numOfPath = 0;
        ArrayList<String> paths = new ArrayList<>();

        public Node(int d, int r){
            this.down = d;
            this.right = r;
        }
    }

    public static Node[][] buildMatrixRandom(int size){
        Node[][] matrix = new Node[size][size];

        for(int i=0 ; i < size ; i++){
            for(int j=0 ; j < size ; j++){
                matrix[i][j].down = (int)Math.random()*20;
                matrix[i][j].right = (int)Math.random()*20;
            }
        }

        return matrix;
    }

    public static Node[][] buildMatrix(int size){
        Node[][] matrix = new Node[size][size];
        Scanner in = new Scanner(System.in);

        for(int i=0 ; i < size ; i++){
            for(int j=0 ; j < size ; j++){
                System.out.println("Enter right , down: ");
                int right = in.nextInt();
                int down = in.nextInt();
                matrix[i][j] = new Node(down,right);
            }
        }

        return matrix;
    }

    public static void CalculateShortestPath(Node[][] matrix){
        matrix[0][0].paths.add(new String());

        for(int i=1 ; i < matrix.length ; i++){
            matrix[0][i].value = matrix[0][i-1].value + matrix[0][i-1].right;
            matrix[0][i].numOfPath = 1;
            String newStr = matrix[0][i-1].paths.get(0) + "r";
            matrix[0][i].paths.add(newStr);

            matrix[i][0].value = matrix[i-1][0].value + matrix[i-1][0].down;
            matrix[i][0].numOfPath = 1;
            newStr = matrix[i-1][0].paths.get(0) + "d";
            matrix[i][0].paths.add(newStr);
        }

        for(int i=1 ; i < matrix.length ; i++){
            for(int j=1 ; j < matrix.length ; j++){
                int priceDown = matrix[i-1][j].value + matrix[i-1][j].down;
                int priceRight = matrix[i][j-1].value + matrix[i][j-1].right;
                matrix[i][j].value = Math.min(priceDown, priceRight);

                if(priceDown < priceRight) {
                    matrix[i][j].numOfPath = matrix[i - 1][j].numOfPath;
                    for(int k=0 ; k < matrix[i-1][j].paths.size(); k++){
                        String newStr = matrix[i-1][j].paths.get(k) + "d";
                        matrix[i][j].paths.add(newStr);
                    }
                }else if(priceDown > priceRight) {
                    matrix[i][j].numOfPath = matrix[i][j - 1].numOfPath;
                    for(int k=0 ; k < matrix[i][j-1].paths.size(); k++){
                        String newStr = matrix[i][j-1].paths.get(k) + "r";
                        matrix[i][j].paths.add(newStr);
                    }
                }
                else {
                    matrix[i][j].numOfPath = matrix[i][j-1].numOfPath + matrix[i-1][j].numOfPath;
                    for(int k=0 ; k < matrix[i-1][j].paths.size(); k++){
                        String newStr = matrix[i-1][j].paths.get(k) + "d";
                        matrix[i][j].paths.add(newStr);
                    }
                    for(int k=0 ; k < matrix[i][j-1].paths.size(); k++){
                        String newStr = matrix[i][j-1].paths.get(k) + "r";
                        matrix[i][j].paths.add(newStr);
                    }
                }
            }
        }
    }

    public static boolean PointsOnPath(Node[][] matrix, int x1, int y1, int x2, int y2){
        boolean checkPoint1 = false;
        boolean checkPoint2 = false;
        ArrayList<String> paths = matrix[matrix.length-1][matrix.length-1].paths;
        ArrayList<String> forX1Y1 = new ArrayList<>();
        ArrayList<String> forX2Y2 = new ArrayList<>();

        for(int i=0 ; i < paths.size() ; i++){
            forX1Y1.add(paths.get(0).substring(0,matrix[x1][y1].paths.get(0).length()));
            forX2Y2.add(paths.get(0).substring(0,matrix[x2][y2].paths.get(0).length()));
        }

        for(int i=0 ; i < forX1Y1.size() ; i++){
            for(int j=0 ; j < matrix[x1][y1].paths.size() ; j++){
                if(forX1Y1.get(i).equals(matrix[x1][y1].paths.get(j))){
                    checkPoint1 = true;
                    break;
                }
            }
        }


        for(int i=0 ; i < forX2Y2.size() ; i++){
            for(int j=0 ; j < matrix[x2][y2].paths.size() ; j++){
                if(forX2Y2.get(i).equals(matrix[x2][y2].paths.get(j))){
                    checkPoint2 = true;
                    break;
                }
            }
        }

        if(checkPoint1 && checkPoint2) return true;
        else return false;
    }

    public static void cheapestPath(Node[][] matrix){
        ArrayList<String> paths = matrix[matrix.length-1][matrix.length-1].paths;
        int[] countSteps = new int[paths.size()];
        for(int i=0 ; i < paths.size() ; i++){
            for(int j=1 ; j < paths.get(i).length() ; j++){
                if(paths.get(i).charAt(j) != paths.get(i).charAt(j-1)){
                    countSteps[i]++;
                }
            }
        }
        int min = 0;
        for(int i=0 ; i < countSteps.length ; i++){
            if(countSteps[i] < countSteps[min]){
                min = i;
            }
        }
        System.out.println("All paths: "+paths);
        System.out.println("The cheapest path is "+paths.get(min));
    }

    public static void printShortestPath(Node[][] matrix){
        int i,j;
        i=j= matrix.length-1;
        String path = "";

        while (i > 0 && j > 0){
            if(matrix[i][j].value - matrix[i][j-1].right == matrix[i][j-1].value){
                path = "r " + path;
                j--;
            }else{
                path = "d " + path;
                i--;
            }
        }

        if(i == 0){
            while(j > 0) {
                path = "r " + path;
                j--;
            }
        }else{
            while (i > 0){
                path = "d " + path;
                i--;
            }
        }
        System.out.println(path);
    }

    public static void main(String[] args){
        Node[][] matrix = {{new Node(3,2),new Node(7,9),new Node(8,4),new Node(8,-1)},
                           {new Node(1,7),new Node(3,5),new Node(2,8),new Node(5,-1)},
                            {new Node(7,0),new Node(2,4),new Node(1,3),new Node(8,-1)},
                            {new Node(-1,5),new Node(-1,8),new Node(-1,1),new Node(-1,-1)}};

//        Node[][] matrix = {{new Node(1,1),new Node(1,-1)},
//                            {new Node(-1,1),new Node(-1,-1)}};

        Node[][]mat = new Node [3][3];
        mat[0][0]= new Node(2,3);
        mat[0][1]= new Node(1,1);
        mat[0][2]= new Node(2,-1);

        mat[1][0] = new Node(1,1);
        mat[1][1] = new Node(1,1);
        mat[1][2] = new Node(1,-1);

        mat[2][0] = new Node(-1,1);
        mat[2][1] = new Node(-1,1);
        mat[2][2] = new Node(0,0);

        CalculateShortestPath(mat);
        cheapestPath(mat);
////        System.out.println("The price of path is: "+matrix[3][3].value);
//        System.out.println("The price of path is: "+matrix[3][3].value);
//        System.out.println("The number of paths is: "+matrix[3][3].numOfPath);
//        printShortestPath(matrix);


    }
}
