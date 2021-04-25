package Algoritems.GlassBall;

public class GlassBall {
    public static int crystal_ball(int floors, int balls) {
        int[][] building = new int[balls + 1][floors + 1];

        for (int i = 0; i < building[0].length; i++) {
            building[0][i] = 0;
            building[1][i] = i;
        }
        for (int i = 2; i < building.length; i++) {
            building[i][0] = 0;
            building[i][1] = 1;
            if (floors >= 2) {
                building[i][2] = 2;
                for (int j = 2; j < building[0].length; j++) {
                    int min = floors + 1;
                    for (int l = 1; l < j; l++) {
                        int temp = Math.max(building[i - 1][l - 1], building[i][j - l]) + 1;
                        if (temp < min) min = temp;
                    }
                    building[i][j] = min;
                }

            }
        }
        return building[balls][floors];
    }

    public static void main(String[] args) {
        System.out.println(crystal_ball(200, 24));
        System.out.println(crystal_ball(1, 20));
    }
}
