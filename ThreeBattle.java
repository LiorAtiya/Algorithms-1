package Algoritems;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeBattle {
    public static int duel3dGame(){
        int count1,count2,count3;
        count1=count2=count3=0;
        double chance;
        ArrayList<Integer> options = new ArrayList<>();
        options.add(1);
        options.add(2);
        options.add(3);
        Collections.shuffle(options);

        switch (options.get(0)){

            case 3: // 3 kill 2
                chance = Math.random();
                if(chance < 0.5) count1++; //1 kill 3
                else count3++; //3 kill 1
                break;

            case 2: //2 try to kill 3
                chance = Math.random();
                if(chance < 0.8){ //2 kill 3, battle between 2,1
                    boolean flag = true;
                    while (flag){
                        chance = Math.random();
                        if(chance < 0.5){ //1 kill 2
                            count1++;
                            flag = false;
                        }else{
                            chance = Math.random();
                            if(chance < 0.8){ //2 kill 1
                                count2++;
                                flag = false;
                            }
                        }
                    }
                 //2 dont kill 3, battle between 1,2,3
                }else if(options.get(1) == 3){ //3 kill 2
                    chance = Math.random();
                    if(chance < 0.5) count1++; //1 kill 3
                    else count3++; //3 kill 1
                }else if(options.get(1) == 1){ //1 dont shot
                    //3 kill 2
                    chance = Math.random();
                    if(chance < 0.5) count1++; //1 kill 3
                    else count3++; //3 kill 1
                }
                break;

            case 1: //1 first, dont shot
                if(options.get(1) == 3){ //3 second, kill 2
                    chance = Math.random();
                    if(chance < 0.5) count1++;//1 kill 3
                    else count3++;//3 kill 1
                }else{
                    if(options.get(1) == 2){ //2 second, try to kill 3
                        chance = Math.random();
                        if(chance < 0.8){ //2 kill 3, battle between 2,1
                            boolean flag = true;
                            while (flag){
                                chance = Math.random();
                                if(chance < 0.5) { //1 kill 2
                                    count1++;
                                    flag = false;
                                }else{
                                    chance = Math.random();
                                    if(chance < 0.8) { //2 kill 1
                                        count2++;
                                        flag = false;
                                    }
                                }
                            }
                        }else{ //2 dont kill 3, 3 kill 2
                            chance = Math.random();
                            if(chance < 0.5) count1++; //1 kill 3
                            else count3++;//3 kill 1
                        }
                    }
                }
                break;
        }

//        System.out.println("Count 1:"+count1+", Count 2: "+count2+", Count 3: "+count3);
        if(count1 == 1) return 1;
        else if(count2 == 1) return 2;
        else return 3;
    }

    public static void simulation(int times){
        double count1,count2,count3;
        count1=count2=count3=0;

        for(int i=0 ; i < times ; i++){
            int winner = duel3dGame();
            if(winner == 1) count1++;
            else if(winner == 2) count2++;
            else count3++;
        }

        System.out.println("Success rates of "+times+" games = Player 1: "+count1/times+" | Player 2: "+count2/times+" | Player 3: "+count3/times);
    }

    public static void main(String[] args){
        simulation(5000000);
    }
}
