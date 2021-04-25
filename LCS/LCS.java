package Algoritems.LCS;

public class LCS {

    public static String greedyLCS(String str1, String str2){
        String common = "";
        int start = 0;
        for(int i=0 ; i < str1.length() ; i++){
            int index = str2.indexOf(str1.charAt(i),start);
            if(index != -1){
                common += str1.charAt(i);
                start = index+1;
            }
        }
        return common;
    }

    public static String improvedGreedyLCS(String str1, String str2){
        String common = "";
        int[] countArr = new int[26];

        for(int i=0 ; i < str2.length() ; i++){
            countArr[str2.charAt(i) - 'a']++;
        }
        int ind1,ind2;
        ind1=ind2=0;

        while(ind1 < Math.min(str2.length(),str1.length())){
            if(countArr[str1.charAt(ind1) - 'a'] > 0){
                while(str1.charAt(ind1) != str2.charAt(ind2)){
                    countArr[str2.charAt(ind2)-'a']--;
                    ind2++;
                }
                common += str1.charAt(ind1);
                countArr[str2.charAt(ind2)-'a']--;
                ind2++;
            }
            ind1++;
        }
        return common;
    }

    public static int[] plusOne(int[] arr){
        int length = arr.length-1;
        int newArr[] = new int[arr.length];
        for(int i = length ; i >= 0 ; i--){
            if(arr[i] == 1) newArr[i] = 0;
            if(arr[i] == 0){
                newArr[i] = 1;
                i--;
                while(i >= 0){
                    newArr[i] = arr[i];
                    i--;
                }
                break;
            }
        }
        return newArr;
    }

    public static String convert2String(int[] arr, String str){
        String s = "";
        for(int i=0 ; i < arr.length ; i++){
            if(arr[i] == 1) s += str.charAt(i);
        }
        return s;
    }

    public static String completeSearch(String str1, String str2){
        int[][] allstr1 = new int[(int)Math.pow(2,str1.length())][str1.length()];
        int[][] allstr2 = new int[(int)Math.pow(2,str2.length())][str2.length()];
        String[] s1 = new String[(int)Math.pow(2,str1.length())];
        String[] s2 = new String[(int)Math.pow(2,str2.length())];
        s1[0] = s2[0] = "";

        for(int i = 1 ; i < allstr1.length ; i++){
            allstr1[i] = plusOne(allstr1[i-1]);
            s1[i] = convert2String(allstr1[i], str1);
        }

        for(int i=1 ; i < allstr2.length ; i++){
            allstr2[i] = plusOne(allstr2[i-1]);
            s2[i] = convert2String(allstr2[i], str2);
        }

        String common = "";
        for(int i = s1.length-1 ; i >= 0 ; i--){
            for(int j = s2.length-1 ; j >= 0 ; j--){
                if(s1[i].equals(s2[j])){
                    if(s1[i].length() > common.length())
                        common = s1[i];
                }
            }
        }

        return common;
    }

    public static void main(String[] args){

//        String x = "abcbdab";
//        String y = "bdcaba";
//        String ans = greedyLCS(x,y);
//        String ans2 = improvedGreedyLCS(y,x);
//        System.out.println("LCS is: "+ans+" ,length: "+ans.length());
//        System.out.println("LCS is: "+ans2+" ,length: "+ans2.length());

        int [] arr = {0,1,1,1};
        String common = completeSearch("bdcaba","abcbdab");
        String common1 = completeSearch("acccccb","bccccca");
        System.out.println(common1);

    }
}
