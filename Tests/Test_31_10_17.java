package Algoritems.Tests;

import java.util.ArrayList;
import java.util.Arrays;

public class Test_31_10_17 {

    static class Node {
        int valueMin;
        int valueMax;
        int right;
        int down;
        ArrayList<String> paths = new ArrayList<>();

        public Node(int down, int right){
            this.right = right;
            this.down = down;
        }
    }

    public static void Q1_A(Node[][] matrix){
        matrix[0][0].paths.add("");
        for(int i=1 ; i < matrix.length ; i++){
            matrix[0][i].valueMax = matrix[0][i-1].right + matrix[0][i-1].valueMax;
            matrix[0][i].valueMin = matrix[0][i-1].right + matrix[0][i-1].valueMin;
            String str = matrix[0][i-1].paths.get(0) + "r";
            matrix[0][i].paths.add(str);

            matrix[i][0].valueMax = matrix[i-1][0].down + matrix[i-1][0].valueMax;
            matrix[i][0].valueMin = matrix[i-1][0].down + matrix[i-1][0].valueMin;
            String str1 = matrix[i-1][0].paths.get(0) + "d";
            matrix[i][0].paths.add(str1);
        }

        for(int i=1 ; i < matrix.length ; i++){
            for(int j=1 ; j < matrix.length ; j++){
                int valueDown = matrix[i-1][j].down + matrix[i-1][j].valueMin;
                int valueRight = matrix[i][j-1].right + matrix[i][j-1].valueMin;
                matrix[i][j].valueMin = Math.min(valueDown,valueRight);

                if(valueDown < valueRight) {
                    for(int k=0 ; k < matrix[i-1][j].paths.size(); k++){
                        String newStr = matrix[i-1][j].paths.get(k) + "d";
                        matrix[i][j].paths.add(newStr);
                    }
                }else if(valueDown > valueRight){
                    for(int k=0 ; k < matrix[i][j-1].paths.size(); k++){
                        String newStr = matrix[i][j-1].paths.get(k) + "r";
                        matrix[i][j].paths.add(newStr);
                    }
                }else{
                    for(int k=0 ; k < matrix[i-1][j].paths.size(); k++){
                        String newStr = matrix[i-1][j].paths.get(k) + "d";
                        matrix[i][j].paths.add(newStr);
                    }
                    for(int k=0 ; k < matrix[i][j-1].paths.size(); k++){
                        String newStr = matrix[i][j-1].paths.get(k) + "r";
                        matrix[i][j].paths.add(newStr);
                    }
                }

                matrix[i][j].valueMax = Math.max(matrix[i-1][j].down + matrix[i-1][j].valueMax ,matrix[i][j-1].right + matrix[i][j-1].valueMax);
            }
        }

        System.out.println("The value of min path is "+matrix[matrix.length-1][matrix.length-1].valueMin);
        System.out.println("The value of max path is "+matrix[matrix.length-1][matrix.length-1].valueMax);
        System.out.println("paths "+matrix[matrix.length-1][matrix.length-1].paths);

    }

    public static boolean Q1_B(Node[][] matrix, int x1, int y1, int x2, int y2){
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

    public static void Q4_B(String X,String Y){
        String str = "";
        int countRemove = 0;
        int countEnter = 0;
        for(int i=0 ; i < X.length(); i++){
            if(Y.contains(""+X.charAt(i))){
                str += X.charAt(i);
            }else{
                countRemove++;
            }
        }
        for(int i=0 ; i < Y.length() ; i++){
            if(i <= str.length()-1){
                if(Y.charAt(i) != str.charAt(i)){
                    str = str.substring(0,i) + Y.charAt(i) + str.substring(i+1, str.length()-1);
                    countEnter++;
                }
            }else{
                while(i < Y.length()){
                    str += Y.charAt(i);
                    countEnter++;
                    i++;
                }
                break;
            }
        }
        System.out.println("New String is "+str+", created with "+countRemove+" removes and "+countEnter+" adds");
    }

    public static void main(String[] args){
        Node[][] matrix = {{new Node(3,2),new Node(7,9),new Node(8,4),new Node(8,-1)},
                            {new Node(1,7),new Node(3,5),new Node(2,8),new Node(5,-1)},
                            {new Node(7,0),new Node(2,4),new Node(1,3),new Node(8,-1)},
                            {new Node(-1,5),new Node(-1,8),new Node(-1,1),new Node(-1,-1)}};

//        Node[][] matrix1 = {{new Node(1,1),new Node(1,1)}
//                            ,{new Node(1,1),new Node(1,1)},
//                                {new Node(1,1),new Node(1,1)}};

//        Node[][] matrix3 = {{new Node(1,1),new Node(1,-1)},
//                    {new Node(-1,1),new Node(-1,-1)}};
//        Q1_A(matrix);
//        System.out.println(Q1_B(matrix,2,2,2,1));
        Q4_B("abcdefh", "bcefg");
    }
}
