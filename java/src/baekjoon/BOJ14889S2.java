package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// 14889 스타트와 링크
public class BOJ14889S2 {
    private static int[][] S;
    private static int N;
    private static List<Pair> combi;
    private static boolean[] visited;
    private static int size;

    public static int combiCount(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        } else {
            return combiCount(n - 1, r - 1) + combiCount(n - 1, r);
        }
    }

    public static void combination(int start, int count) {
        if (combi.size() > size / 2 - 1) {
            return;
        }
        if (count == N / 2) {
            int aIndex = 0;
            int bIndex = 0;
            int[] A = new int[N / 2];
            int[] B = new int[N / 2];
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    A[aIndex++] = i;
                } else {
                    B[bIndex++] = i;
                }
            }
            combi.add(new Pair(A, B));
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            combination(i + 1, count + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi = new ArrayList<>();
        visited = new boolean[N];
        size = combiCount(N, N / 2);

        combination(0, 0);

        int answer = getAnswer();

        System.out.println(answer);
    }

    private static int getAnswer() {
        int answer = Integer.MAX_VALUE;
        for (Pair tmp : combi) {
            int[] aTeam = tmp.A;
            int[] bTeam = tmp.B;

            int aSum = 0;
            int bSum = 0;
            for (int i = 0; i < N / 2; i++) {
                for (int j = i + 1; j < N / 2; j++) {
                    aSum += S[aTeam[i]][aTeam[j]] + S[aTeam[j]][aTeam[i]];
                    bSum += S[bTeam[i]][bTeam[j]] + S[bTeam[j]][bTeam[i]];
                }
            }

            answer = Math.min(answer, Math.abs(aSum - bSum));
        }
        return answer;
    }

    static class Pair {
        private int[] A;
        private int[] B;

        public Pair(int[] a, int[] b) {
            A = a;
            B = b;
        }
    }
}
