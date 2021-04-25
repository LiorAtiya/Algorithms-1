
public class Q2 {
    public static int longestOfOne(int[] arr) {
        int[] count = new int[arr.length];
        int c = 1;
        for(int i=0 ; i < arr.length ; i++){
            if(arr[i] == 1){
                count[i] = c;
                c++;
            }else{
                c = 1;
            }
        }
        int max = 0;
        for(int i=0 ; i < count.length ; i++){
            if(count[i] > max) max = count[i];
        }

        return max;
    }

    public static int imaginaryPlus(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[][] up = new int[n][m];
        int[][] down = new int[n][m];
        int[][] left = new int[n][m];
        int[][] r = new int[n][m];

        for (int i = 0; i < m; i++) {
            up[0][i] = arr[0][i];
        }

        for (int i = 0; i < m; i++) {
            down[n-1][i] = arr[n-1][i];
        }
        for (int i = 0; i < n; i++) {
            left[i][0] = arr[i][0];
        }
        for (int i = 0; i < n; i++) {
            r[i][m-1] = arr[i][m-1];
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] != 0) {
                    if(i != 0) {
                        up[i][j] = up[i-1][j] + 1;
                    }
                    if(j != 0) {
                        left[i][j] = left[i][j-1] + 1;
                    }
                }
            }
        }
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                if(arr[i][j] != 0) {
                    if(i != n-1) {down[i][j] = down[i+1][j] + 1;}
                    if(j != m-1) {r[i][j] = r[i][j+1] + 1;}
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(Math.min(Math.min(up[i][j], down[i][j]),Math.min(left[i][j], r[i][j])) > max) {
                    max = Math.min(Math.min(up[i][j], down[i][j]),Math.min(left[i][j], r[i][j]));
                }
            }
        }
        return (max)*4 + 1;
    }

}
