package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NQueenPlus {
    private static int N;
    private static boolean[] col;
    private static boolean[] left;
    private static boolean[] right;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        col = new boolean[N + 1];
        left = new boolean[2 * N + 1];
        right = new boolean[2 * N + 1];
        answer = 0;

        setQueen(1);
        System.out.println(answer);
    }

    // 해당 퀸을 현재 행에 가능한 모든 곳에 놓아보기
    private static void setQueen(int row) {
        // 기저조건
        if (row > N) {
            answer += 1;
            return;
        }
        // 유도파트
        for (int c = 1; c <= N; c++) {
            if (!col[c] && !left[row - c + N] && !right[row + c]) {
                col[c] = true;
                left[row - c + N] = true;
                right[row + c] = true;
                setQueen(row + 1);
                col[c] = false;
                left[row - c + N] = false;
                right[row + c] = false;
            }
        }
    }
}
