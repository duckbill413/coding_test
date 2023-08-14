package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PermutationRec {
    private static int N;
    private static int M;
    private static int[] A;
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = i + 1;
        }

        visited = new boolean[N];
        count = 0;
        combination(0);
        System.out.println(count);
    }

    private static void combination(int depth) {
        if (depth == M) {
            count++;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    System.out.print(A[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            combination(depth + 1);
            visited[i] = false;
        }
    }
}
