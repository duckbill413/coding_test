package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NQueen {
    private static int N;
    private static int[] col;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        col = new int[N + 1];
        answer = 0;

        setQueen(1);
        System.out.println(answer);
    }

    // 해당 퀸을 현재 행에 가능한 모든 곳에 놓아보기
    private static void setQueen(int row) {
        // 가지치기
        if (!isAvailable(row - 1)) return;
        // 기저조건
        if (row > N) {
//            System.out.println(Arrays.toString(col));
            answer += 1;
            return;
        }
        // 유도파트
        for (int c = 1; c <= N; c++) {
            col[row] = c;
            setQueen(row + 1);
        }
    }

    private static boolean isAvailable(int row) {
        for (int i = 1; i < row; i++) {
            if (col[i] == col[row] || Math.abs(col[i] - col[row]) == row - i) {
                return false;
            }
        }
        return true;
    }
}
