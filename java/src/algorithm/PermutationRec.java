package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PermutationRec {
    private static int N;
    private static int M;
    private static int[] A;
    private static boolean[] visited;
    private static int[] result;
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
        result = new int[M];
        count = 0;
        permutation(0);
        System.out.println(count);
    }

    private static void permutation(int depth) {
        if (depth == M) {
            count++;
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            result[depth] = A[i];
            permutation(depth + 1);
            visited[i] = false;
        }
    }
}
