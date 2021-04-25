package Algoritems;

import java.util.Arrays;

public class SecretaryProblem {
    public static double secretaryProblem(int times[]){
        Arrays.sort(times);
        double average = times[0];
        for(int i=1 ; i < times.length ; i++){
            times[i] = times[i] + times[i-1];
            average += times[i];
        }

        double ans = average/times.length;
        return ans;
    }

    public static void main(String[] args){
        int[] arr = {3,2,1};
        System.out.println(secretaryProblem(arr));
    }
}
