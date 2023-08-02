package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class SWEA2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] board = new int[N][];
            for (int i = 0; i < N; i++) {
                board[i] = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }
            int answer = 0;
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = N / 2 - count; j < N / 2 + count + 1; j++) {
                    answer += board[i][j];
                }
                if (i < (int) N / 2)
                    count++;
                else {
                    count--;
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}