package Algoritems;

public class Pizza {
    public static int betterDividePizza(double x, int n){
        int k = (int)x + 1;
        int p = n/(k+1), r = n % (k+1);
        int ans = -1;
        if(r != 1){
            double t = (x*p + r - 1);
            if(t < x/(x+1)){
                ans = 1;
            }else{
                ans = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args){

    }
}
