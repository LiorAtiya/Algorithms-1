//package Algoritems;
//
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class ThreeWayBattle {
//
//    public static int play123() {
//        double chance = Math.random();
//        int player1,player2,player3;
//        player1=player2=player3=1;
//
//        while(true){
//            //Turn player1
//            if(player2 == 1) if(chance < 1) player2--;
//            else if(player3 == 1) if(chance < 1) player3--;
//
//            if(player1 == 1 && player2 == 0 && player3 == 0) return 1;
//            if(player2 == 1 && player1 == 0 && player3 == 0) return 2;
//            if(player3 == 1 && player2 == 0 && player1 == 0) return 3;
//
//            //Turn player2
//            if(player1 == 1) if(chance < 0.8) player1--;
//            else if(player3 == 1) if(chance < 0.8) player3--;
//
//            if(player1 == 1 && player2 == 0 && player3 == 0) return 1;
//            if(player2 == 1 && player1 == 0 && player3 == 0) return 2;
//            if(player3 == 1 && player2 == 0 && player1 == 0) return 3;
//
//            //Turn player3
//            if(player1 == 1) if(chance < 0.5) player1--;
//            else if(player2 == 1) if(chance < 0.5) player2--;
//
//            if(player1 == 1 && player2 == 0 && player3 == 0) return 1;
//            if(player2 == 1 && player1 == 0 && player3 == 0) return 2;
//            if(player3 == 1 && player2 == 0 && player1 == 0) return 3;
//        }
//
//    }
//    public static int play132() {
//        double chance = Math.random();
//        int player1,player2,player3;
//        player1=player2=player3=1;
//
//        while(true){
//            //Turn player1
//            if(player2 == 1) if(chance < 1) player2--;
//            else if(player3 == 1) if(chance < 1) player3--;
//
//            if(player1 == 1 && player2 == 0 && player3 == 0) return 1;
//            if(player2 == 1 && player1 == 0 && player3 == 0) return 2;
//            if(player3 == 1 && player2 == 0 && player1 == 0) return 3;
//
//            //Turn player3
//            if(player1 == 1) if(chance < 0.8) player1--;
//            else if(chance < 0.8) player3--;
//
//            if(player1 == 1 && player2 == 0 && player3 == 0) return 1;
//            if(player2 == 1 && player1 == 0 && player3 == 0) return 2;
//            if(player3 == 1 && player2 == 0 && player1 == 0) return 3;
//
//            //Turn player1
//            if(player1 == 1) if(chance < 0.5) player1--;
//            else if(chance < 0.5) player2--;
//
//            if(player1 == 1 && player2 == 0 && player3 == 0) return 1;
//            if(player2 == 1 && player1 == 0 && player3 == 0) return 2;
//            if(player3 == 1 && player2 == 0 && player1 == 0) return 3;
//        }
//    }
//    public static boolean play231() {
//        double chance = Math.random();
//        int player1,player2,player3;
//        player1=player2=player3=1;
//
//        while(true){
//            //Turn player1
//            if(player2 == 1) if(chance < 1) player2--;
//            else if(chance < 1) player1--;
//
//            if(player1 == 1 && player2 == 0 && player3 == 0) return 1;
//            if(player2 == 1 && player1 == 0 && player3 == 0) return 2;
//            if(player3 == 1 && player2 == 0 && player1 == 0) return 3;
//
//            //Turn player2
//            if(player1 == 1) if(chance < 0.8) player1--;
//            else if(chance < 0.8) player3--;
//
//            if(player1 == 1 && player2 == 0 && player3 == 0) return 1;
//            if(player2 == 1 && player1 == 0 && player3 == 0) return 2;
//            if(player3 == 1 && player2 == 0 && player1 == 0) return 3;
//
//            //Turn player3
//            if(player1 == 1) if(chance < 0.5) player1--;
//            else if(chance < 0.5) player2--;
//
//            if(player1 == 1 && player2 == 0 && player3 == 0) return 1;
//            if(player2 == 1 && player1 == 0 && player3 == 0) return 2;
//            if(player3 == 1 && player2 == 0 && player1 == 0) return 3;
//        }
//    }
//    public static boolean play213() {
//        double chance = Math.random();
//        int player1,player2,player3;
//        player1=player2=player3=1;
//
//        while(true){
//            //Turn player1
//            if(player2 == 1) if(chance < 1) player2--;
//            else if(chance < 1) player1--;
//
//            if(player1 == 1 && player2 == 0 && player3 == 0) return 1;
//            if(player2 == 1 && player1 == 0 && player3 == 0) return 2;
//            if(player3 == 1 && player2 == 0 && player1 == 0) return 3;
//
//            //Turn player2
//            if(player1 == 1) if(chance < 0.8) player1--;
//            else if(chance < 0.8) player3--;
//
//            if(player1 == 1 && player2 == 0 && player3 == 0) return 1;
//            if(player2 == 1 && player1 == 0 && player3 == 0) return 2;
//            if(player3 == 1 && player2 == 0 && player1 == 0) return 3;
//
//            //Turn player3
//            if(player1 == 1) if(chance < 0.5) player1--;
//            else if(chance < 0.5) player2--;
//
//            if(player1 == 1 && player2 == 0 && player3 == 0) return 1;
//            if(player2 == 1 && player1 == 0 && player3 == 0) return 2;
//            if(player3 == 1 && player2 == 0 && player1 == 0) return 3;
//        }
//    }
//    public static boolean play312() {
//        double chance = Math.random();
//        int player1,player2,player3;
//        player1=player2=player3=1;
//
//        while(true){
//            //Turn player1
//            if(player2 == 1) if(chance < 1) player2--;
//            else if(chance < 1) player1--;
//
//            if(player1 == 1 && player2 == 0 && player3 == 0) return 1;
//            if(player2 == 1 && player1 == 0 && player3 == 0) return 2;
//            if(player3 == 1 && player2 == 0 && player1 == 0) return 3;
//
//            //Turn player2
//            if(player1 == 1) if(chance < 0.8) player1--;
//            else if(chance < 0.8) player3--;
//
//            if(player1 == 1 && player2 == 0 && player3 == 0) return 1;
//            if(player2 == 1 && player1 == 0 && player3 == 0) return 2;
//            if(player3 == 1 && player2 == 0 && player1 == 0) return 3;
//
//            //Turn player3
//            if(player1 == 1) if(chance < 0.5) player1--;
//            else if(chance < 0.5) player2--;
//
//            if(player1 == 1 && player2 == 0 && player3 == 0) return 1;
//            if(player2 == 1 && player1 == 0 && player3 == 0) return 2;
//            if(player3 == 1 && player2 == 0 && player1 == 0) return 3;
//        }
//    }
//    public static boolean play321() {
//        double chance = Math.random();
//        int player1,player2,player3;
//        player1=player2=player3=1;
//
//        while(true){
//            //Turn player1
//            if(player2 == 1) if(chance < 1) player2--;
//            else if(chance < 1) player1--;
//
//            if(player1 == 1 && player2 == 0 && player3 == 0) return 1;
//            if(player2 == 1 && player1 == 0 && player3 == 0) return 2;
//            if(player3 == 1 && player2 == 0 && player1 == 0) return 3;
//
//            //Turn player2
//            if(player1 == 1) if(chance < 0.8) player1--;
//            else if(chance < 0.8) player3--;
//
//            if(player1 == 1 && player2 == 0 && player3 == 0) return 1;
//            if(player2 == 1 && player1 == 0 && player3 == 0) return 2;
//            if(player3 == 1 && player2 == 0 && player1 == 0) return 3;
//
//            //Turn player3
//            if(player1 == 1) if(chance < 0.5) player1--;
//            else if(chance < 0.5) player2--;
//
//            if(player1 == 1 && player2 == 0 && player3 == 0) return 1;
//            if(player2 == 1 && player1 == 0 && player3 == 0) return 2;
//            if(player3 == 1 && player2 == 0 && player1 == 0) return 3;
//        }
//    }
//
//    public static void Game(){
//        boolean victory = false;
//        ArrayList<Integer> options = new ArrayList<>();
//        options.add(1);
//        options.add(2);
//        options.add(3);
//        Collections.shuffle(options);
//        String turn = ""+options.get(0)+options.get(1)+options.get(2);
//
//        while(!victory){
//            switch (turn){
//                case "123":
//                    break;
//                case "132":
//                    break;
//
//                case "231":
//                    break;
//
//                case "213":
//                    break;
//
//                case "312":
//                    break;
//
//                case "321":
//                    break;
//            }
//        }
//    }
//}
