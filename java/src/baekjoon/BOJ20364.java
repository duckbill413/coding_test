package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 20364 부동산 다툼
public class BOJ20364 {
    private static int N, Q;
    private static boolean[] land;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        land = new boolean[N * 2 + 1];

        sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int wish = Integer.parseInt(br.readLine());
            findMyLand(wish, wish, 2 * N + 1);
        }

        System.out.println(sb);
    }
    private static void findMyLand(int start, int wish, int small) {
        if (start == 1) {
            if (small == 2 * N + 1) {
                land[wish] = true;
                sb.append(0).append("\n");
            } else {
                sb.append(small).append("\n");
            }
            return;
        } else if (land[start]) {
            small = start;
        }

        findMyLand(start / 2, wish, small);
    }
}
