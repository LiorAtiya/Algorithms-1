package Algoritems.LCS;

public class LCS_Dynamic {
    public static void LCSDynamic(String s1, String s2){
        String str1;
        String str2;

        if(s1.length() < s2.length()){
            str1 = s2;
            str2 = s1;
        }else{
            str1 = s1;
            str2 = s2;
        }

        int matrix[][] = new int[str1.length()+1][str2.length()+1];

        for(int i=1 ; i <= str1.length() ; i++){
            for(int j=1 ; j <= str2.length() ; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    matrix[i][j] += matrix[i-1][j-1]+1;
                }else{
                    matrix[i][j] = Math.max(matrix[i-1][j],matrix[i][j-1]);
                }
            }
        }
        int i = matrix.length-1;
        int j = matrix[0].length-1;
        int count = matrix[i][j]-1;
        String common = "";

        while(count >= 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                common = str1.charAt(i-1) + common;
                i--; j--; count--;
            }else if(matrix[i][j] == matrix[i][j-1]){
                j--;
            }else{
                i--;
            }
        }

        System.out.println("The largest string common is "+matrix[str1.length()][str2.length()]);
        System.out.println(common);
    }

    public static void main(String[] args){
        String str1 = "abcbdab";
        String str2 = "bdcaba";

//        LCSDynamic(str1,str2);
        LCSDynamic("abba","kbbbc");

    }
}
