package Algoritems;

public class Pow_fibonaci {
    //O(log2n)
    public static int pow(int base,int exponent,int ans){
        if(exponent == 0) return ans;
        if(exponent % 2 == 1) ans *= base;
        exponent = exponent/2;
        base *= base;
        return pow(base,exponent,ans);
    }

    //O(log2n)
    public static int fibonaci(int num){
        int ans[][] = {{1,1},{1,0}};
        int A[][] = {{1,1},{1,0}};

        while(num != 0){
            if(num % 2 == 1) ans = multiplicar(ans,A);
            A = multiplicar(A,A);
            num = num/2;
        }
        return ans[1][1];
    }

    public static int[][] multiplicar(int[][] A, int[][] B) {

        int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        int[][] C = new int[aRows][bColumns];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                C[i][j] = 0;
            }
        }

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
                for (int k = 0; k < aColumns; k++) { // aColumn
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    public static void main(String[] args){
//        System.out.println(pow(2,6,1));
        System.out.println(fibonaci(8));
    }
}
