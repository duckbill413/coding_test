package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CombinationRec {
    private static int N;
    private static int M;
    private static int[] A;
    private static boolean[] visited;

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
        combination(0, 0);
    }

    private static void combination(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    System.out.print(A[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            combination(i+1, depth+1);
            visited[i] = false;
        }
    }
}
