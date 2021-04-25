package Algoritems.AliceAndBob;

import java.util.Arrays;
import java.util.Random;

public class AliceAndBob {

    public static int coinFlip(){
        Random rnd = new Random();
        int coin = rnd.nextInt(2);
        return coin;
    }

    public static boolean StrategyVictory(){
        int[] alice = new int[4];
        int[] bob = new int[4];
        int[][] guess = new int[2][alice.length];

        for(int i=0 ; i < alice.length ; i++){
            alice[i] = coinFlip();
            bob[i] = coinFlip();

            guess[0][i] = alice[i];

            if(bob[i] == 1) guess[1][i] = 0;
            else guess[1][i] = 1;
        }

        System.out.println("Table of alice: "+Arrays.toString(alice));
        System.out.println("Table of bob: "+Arrays.toString(bob));

        System.out.println("Guess of alice: "+Arrays.toString(guess[0]));
        System.out.println("Guess of bob: "+Arrays.toString(guess[1]));

//        for(int i = 0 ; i < guess[0].length ; i++){
//            guess[0][i] = alice[i];
//        }
//        for(int i = 0 ; i < guess[0].length ; i++){
//            if(bob[i] == 1) guess[1][i] = 0;
//            else guess[1][i] = 1;
//        }

        for(int i= 0 ; i < alice.length ; i++){
            if(guess[0][i] != bob[i] && guess[1][i] != alice[i]) return false;
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(StrategyVictory());
    }
}
