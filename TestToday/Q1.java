
public class Q1 {
    public static int lcs(int[]X , int[]Y){
        int[] x;
        int[] y;

        if(X.length < Y.length){
            x = Y;
            y = X;
        }else{
            x = X;
            y = Y;
        }

        int matrix[][] = new int[x.length+1][y.length+1];

        for(int i=1 ; i <= x.length ; i++){
            for(int j=1 ; j <= y.length ; j++){
                if(x[i-1] == y[j-1]){
                    matrix[i][j] += matrix[i-1][j-1]+1;
                }else{
                    matrix[i][j] = Math.max(matrix[i-1][j],matrix[i][j-1]);
                }
            }
        }
        int count = matrix[matrix.length-1][matrix[0].length-1];

        return count;
    }

    public static int lcs3(int[] X, int[] Y, int[] Z) {
        int[] x;
        int[] y;

        if(X.length < Y.length){
            x = Y;
            y = X;
        }else{
            x = X;
            y = Y;
        }


        int matrix[][] = new int[x.length+1][y.length+1];

        for(int i=1 ; i <= x.length ; i++){
            for(int j=1 ; j <= y.length ; j++){
                if(x[i-1] == y[j-1]){
                    matrix[i][j] += matrix[i-1][j-1]+1;
                }else{
                    matrix[i][j] = Math.max(matrix[i-1][j],matrix[i][j-1]);
                }
            }
        }

        int i = matrix.length-1;
        int j = matrix[0].length-1;
        int count = matrix[i][j]-1;
        int[] common = new int[count+1];
        int index = common.length-1;

        while(count >= 0){
            if(x[i-1] == y[j-1]){
                common[index] = x[i-1];
                i--; j--; count--; index--;
            }else if(matrix[i][j] == matrix[i][j-1]){
                j--;
            }else{
                i--;
            }
        }

        int[] a;
        int[] b;

        if(common.length < Z.length){
            a = Z;
            b = common;
        }else{
            a = common;
            b = Z;
        }

        matrix = new int[a.length+1][b.length+1];

        for(int k=1 ; k <= a.length ; k++){
            for(int l=1 ; l <= b.length ; l++){
                if(a[k-1] == b[l-1]){
                    matrix[k][l] += matrix[k-1][l-1]+1;
                }else{
                    matrix[k][l] = Math.max(matrix[k-1][l],matrix[k][l-1]);
                }
            }
        }

        count = matrix[matrix.length-1][matrix[0].length-1];

        return count;
    }
}
