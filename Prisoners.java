package Algoritems;

import java.util.Random;

public class Prisoners {

    public static void lampIsOn(int num){
        Random rand = new Random();
        boolean[] enter = new boolean[num];
        int count = 1;
        boolean lamp = true;
        int rndPrisoner;
        int total = 0;

        while(count < num){
            rndPrisoner = rand.nextInt(num);
            if(rndPrisoner == 0){
                if(!lamp){
                    lamp = true;
                    count++;
                }
            }else if(enter[rndPrisoner] == false && lamp){
                lamp = false;
                enter[rndPrisoner] = true;
            }
            total++;
        }
        enter[0] = true;

        System.out.println(total);

    }

    public static void lampIsUnknown(int num){
        Random rand = new Random();
        int[] enter = new int[num];
        int count = 2;
        int rndPrisoner;
        int total = 0;
        boolean lamp;

        int onOff = rand.nextInt(2);
        if(onOff == 1) lamp = true;
        else lamp = false;

        while(count < num*2){
            rndPrisoner = rand.nextInt(num);
            if(rndPrisoner == 0){
                if(!lamp){
                    lamp = true;
                    count++;
                }
            }else if(enter[rndPrisoner] < 2 && lamp){
                lamp = false;
                enter[rndPrisoner]++;
            }
            total++;
        }

        System.out.println(total);
    }

    public static void main(String[] args){
        lampIsOn(100);
        lampIsUnknown(100);
    }
}
