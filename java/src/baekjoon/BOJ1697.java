package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1697 {
    private static int SIZE = 100001;
    private static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));
    }

    private static int bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] time = new int[SIZE];
        Arrays.fill(time, Integer.MAX_VALUE);
        q.add(start);
        time[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == M) return time[M];

            if (cur < M && time[cur] + 1 < time[cur + 1]) {
                time[cur + 1] = time[cur] + 1;
                q.add(cur + 1);
            }
            if (cur - 1 >= 0 && time[cur] + 1 < time[cur - 1]) {
                time[cur - 1] = time[cur] + 1;
                q.add(cur - 1);
            }
            if (cur * 2 <= M + 1 && time[cur] + 1 < time[cur * 2]) {
                time[cur * 2] = time[cur] + 1;
                q.add(cur * 2);
            }
        }
        return time[M];
    }
}
