package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4012 요리사 (메모리 20,496 kb, 시간 135ms)
public class SWEA4012 {
    private static int N;
    private static int[] row, col;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
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
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
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