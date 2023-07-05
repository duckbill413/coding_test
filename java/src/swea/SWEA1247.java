package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1247 {
    public final static int INF = 987654321;
    public static int result;
    public static int N;
    public static int[][] point;
    public static boolean[] visited;

    public static int getDistance(int a, int b, int x, int y) {
        return Math.abs(a - x) + Math.abs(b - y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());

            // 각각 거리 사이의 길이 구하기
            st = new StringTokenizer(br.readLine());
            point = new int[N + 2][2];
            for (int i = 0; i < N + 2; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                point[i][0] = x;
                point[i][1] = y;
            }
            result = INF;
            visited = new boolean[N + 2];
            process(0, point[0], 0);
            System.out.printf("#%d %d\n", test_case, result);
        }
    }

    public static void process(int count, int[] current, int distance) {
        if (distance >= result) {
            return;
        }
        if (count == N) {
            distance += getDistance(current[0], current[1], point[1][0], point[1][1]);
            result = Math.min(result, distance);
        }
        for (int i = 2; i < N + 2; i++) {
            if (!visited[i]) {
                visited[i] = true;
                process(count + 1, point[i], distance + getDistance(current[0], current[1], point[i][0], point[i][1]));
                visited[i] = false;
            }
        }
    }
}