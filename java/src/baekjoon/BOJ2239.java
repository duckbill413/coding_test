package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2239 {
    private static int[][] sudocu;
    private static boolean [][] house;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sudocu = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudocu[i][j] = Character.getNumericValue(tmp.charAt(j));
            }

    }
}
