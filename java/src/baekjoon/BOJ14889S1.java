package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 14889 스타트와 링크
public class BOJ14889S1 {
    private static int N;
    private static int[] row, col;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        row = new int[N];
        col = new int[N];
        int total = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int s = Integer.parseInt(st.nextToken());
                total += s;
                row[i] += s;
                col[j] += s;
            }
        }
        combination(0, 0, total);
        System.out.println(answer);
        br.close();
    }

    public static void combination(int num, int size, int total) {
        if (size == N / 2) {
            answer = Math.min(answer, Math.abs(total));
            return;
        } else if (num == N) {
            return;
        }

        combination(num + 1, size + 1, total - row[num] - col[num]);
        combination(num + 1, size, total);
    }
}
