package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 1697 숨바꼭질 (메모리: 13952KB, 시간: 108ms)
public class BOJ1697 {
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
        int[] time = new int[Math.max(N + 1, M + 2)];
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == M) break;

            if (cur < M && time[cur + 1] == 0) {
                time[cur + 1] = time[cur] + 1;
                q.add(cur + 1);
            }
            if (cur - 1 >= 0 && time[cur - 1] == 0) {
                time[cur - 1] = time[cur] + 1;
                q.add(cur - 1);
            }
            if (cur * 2 <= M + 1 && time[cur * 2] == 0) {
                time[cur * 2] = time[cur] + 1;
                q.add(cur * 2);
            }
        }
        return time[M];
    }
}
