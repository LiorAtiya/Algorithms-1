package Algoritems.GameOfNumbers;

public class GameOfNumbers {

    public static void greedyAlgorithm(int[] arr){
        int alice = 0;
        int bob = 0;
        int low = 0;
        int high = arr.length-1;

        while(low < high){
            //Turn of alice
            if(arr[low] > arr[high]) {
                alice += arr[low];
                low++;
            }else {
                alice += arr[high];
                high--;
            }

            //Turn of bob
            if(arr[low] > arr[high]) {
                bob += arr[low];
                low++;
            }else {
                bob += arr[high];
                high--;
            }
        }

        if(alice > bob){
            System.out.println("Alice win with "+alice+" points");
        }else if(alice < bob){
            System.out.println("Bob win with "+bob+" points");
        }else{
            System.out.println("Equals between alice and bob");
        }
    }

    public static void oddOrEvenAlgorithm(int[] arr){
        int sumOdd = 0;
        int sumEven = 0;
        int alice = 0;
        int bob = 0;

        for(int i=0 ; i < arr.length ; i++){
            if(i % 2 == 0) sumEven += arr[i];
            else sumOdd += arr[i];
        }

        boolean even;
        int low = 0;
        int high = arr.length-1;
        if(sumOdd > sumEven){
            even = false;
        }else even = true;

        while(low < high){
            if(even && (low % 2 == 0) || !even && (low % 2 != 0)) alice += arr[low++];
            else alice += arr[high--];

            if(arr[low] > arr[high]) bob += arr[low++];
            else bob += arr[high--];
        }

        if(alice > bob){
            System.out.println("Alice win with "+alice+" points");
        }else if(alice < bob){
            System.out.println("Bob win with "+bob+" points");
        }else{
            System.out.println("Equals between alice and bob");
        }
    }

    public static void EvenOddAdaptiveAlgorithm(int[] arr){
        int sumOdd = 0;
        int sumEven = 0;
        int alice = 0;
        int bob = 0;

        for(int i=0 ; i < arr.length ; i++){
            if(i % 2 == 0) sumEven += arr[i];
            else sumOdd += arr[i];
        }

        boolean even;
        int low = 0;
        int high = arr.length-1;
        if(sumOdd >= sumEven){
            even = false;
        }else even = true;

        while(low < high){
            int temp1 = low;
            int temp2 = high;
            if(even && (low % 2 == 0) || !even && (low % 2 != 0)) alice += arr[low++];
            else alice += arr[high--];

            if(arr[low] > arr[high]) bob += arr[low++];
            else bob += arr[high--];

            if(low != temp1) {
                if (temp1 % 2 == 0) sumEven -= arr[temp1];
                else sumOdd -= arr[temp1];
            }else {
                if (temp2 % 2 == 0) sumEven -= arr[temp2];
                else sumOdd -= arr[temp2];
            }

            if(sumOdd > sumEven){
                even = false;
            }else even = true;
        }

        if(alice > bob){
            System.out.println("Alice win with "+alice+" points");
        }else if(alice < bob){
            System.out.println("Bob win with "+bob+" points");
        }else{
            System.out.println("Equals between alice and bob");
        }
    }

    public static void completeSearch(int[] arr){

        class Node {
            public int data;
            public int left;
            public int right;
            public String path;

            public Node(int left,int right){
                this.left = left;
                this.right = right;
                this.data = 0;
                path = "";
            }
        }

        Node[] game = new Node[(int)Math.pow(2,arr.length)-1];
        game[0] = new Node(0,arr.length-1);;

        //create tree of index
        for(int i=0 ; i < game.length/2 ; i++){
            game[left_child(i)] = new Node(game[i].left+1, game[i].right);
            game[right_child(i)] = new Node(game[i].left, game[i].right-1);
        }

        //set value and path of leaves
        for(int i=game.length/2 ; i < game.length ; i++){
            game[i].data = arr[game[i].left];
            game[i].path = game[i].right + "";
        }

        //set value and path of inner vertices
        for(int i = game.length/2 - 1 ; i >= 0 ; i--){
            if(arr[game[i].left] - game[left_child(i)].data >=
                arr[game[i].right] - game[right_child(i)].data){
                game[i].data = arr[game[i].left] - game[left_child(i)].data;
                game[i].path = game[i].left + "->" + game[left_child(i)].path;
            }else{
                game[i].data = arr[game[i].right] - game[2*i+2].data;
                game[i].path = game[i].right + "->" + game[right_child(i)].path;
            }
        }

        System.out.println("value = " + game[0].data);
        System.out.println("path = " + game[0].path);
    }

    public static int left_child(int i) {
        return (2 * i) + 1;
    }

    public static int right_child(int i) {
        return (2 * i) + 2;
    }

    public static void main(String[] args){
//        int[] arr1 = {5,200,10,1};
//        int[] arr2 = {5,7,8,4,9,9,13,2};
//        int[] arr3 = {1,3,6,1,3,6};
//        System.out.print("greedyAlgorithm: ");
//        greedyAlgorithm(arr1);
//        System.out.print("oddOrEvenAlgorithm: ");
//        oddOrEvenAlgorithm(arr1);
//        System.out.print("EvenOddAdaptiveAlgorithm: ");
//        EvenOddAdaptiveAlgorithm(arr3);
        int[] arr = {4,1,5,9};
        int[] arr2 = {1,3,6,1,3,6};
//        completeSearch(arr);
        completeSearch(arr2);

    }
}
