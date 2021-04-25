package Algoritems.MinMax;

public class fibonacci {
    public static long fiboRec(long x){
        if(x == 0) return 0;
        if(x == 1) return 1;
        return fiboRec(x-1) + fiboRec(x-2);
    }

    public static int fiboLeaves(int x){
        if(x == 0 || x == 1) return 1;
        return fiboLeaves(x-1) + fiboLeaves(x-2);
    }
    public static int fiboInternalNodes(int x){
        if(x == 0 || x == 1) return 0;
        return fiboInternalNodes(x-1) + fiboInternalNodes(x-2) + 1;
    }

    public static int fiboLeaner(int x){
        int a = 0;
        int b = 1;
        int ans = 0;
        for(int i=1 ; i < x ; i++){
            ans = a + b;
            a = b;
            b = ans;
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println("fiboRec: "+fiboRec(40));
//        System.out.println("Number of leaves in fiboRec: "+fiboLeaves(4));
//        int x = fiboInternalNodes(3);
//        System.out.println("Number of internal nodes in fiboRec: "+fiboInternalNodes(3));
//        System.out.println("fiboLeaner: "+fiboLeaner(10));
    }
}
