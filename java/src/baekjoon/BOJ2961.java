package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2961 도영이가 만든 맛있는 음식
public class BOJ2961 {
    private static int N;
    private static int[][] ingredients;
    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        ingredients = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ingredients[i][0] = Integer.parseInt(st.nextToken());
            ingredients[i][1] = Integer.parseInt(st.nextToken());
        }

        answer = Integer.MAX_VALUE;
        visited = new boolean[N];

        for (int target = 1; target<=N; target++) {
            combination(0, 0, target);
        }
        System.out.println(answer);
    }

    private static void combination(int num, int size, int target) {
        if (answer == 0) {
            return;
        }
        if (size == target) {
            int A = 1;
            int B = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    A *= ingredients[i][0];
                    B += ingredients[i][1];
                }
            }
            answer = Math.min(answer, Math.abs(A - B));
            return;
        } else if (num == N) {
            return;
        }
        visited[num] = true;
        combination(num + 1, size + 1, target);
        visited[num] = false;
        combination(num + 1, size, target);
    }
}
