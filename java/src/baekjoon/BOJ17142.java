package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 바이러스는 활성/비활성 상태가 있다.
 * 2. 활성 상태의 바이러스는 상하좌우 인접한 빈칸에 동시에 복제되어 1초가 걸린다.
 * 3. 연구소의 바이러스중 M개를 활성상태로 만들려고 한다.
 * 4. 연구소는 빈 칸, 벽, 바이러스로 이루어져 있다.
 * 5. 활성 바이러스가 비활성 바이러스 칸으로 가면 비활성 바이러스가 활성으로 변한다.
 * 6. 0: 빈칸, 1: 벽, 2: 바이러스
 */
public class BOJ17142 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int N, M;
    private static int[][] A;
    private static List<Virus> virus;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][N];

        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == 2) {
                    virus.add(new Virus(i, j));
                }
            }
        }

        int[] p = new int[N];
        int cnt = 0;
        while (++cnt <= M) p[N - cnt] = 1;

        answer = Integer.MAX_VALUE;
        do {
            int[][] B = new int[N][N];
            for (int i = 0; i < N; i++) {
                B[i] = Arrays.copyOf(A[i], N);
            }
            for (int i = 0; i < N; i++) {
                if (p[i] == 0) continue;
                Queue<Virus> q = new ArrayDeque<>();
                q.add(virus.get(i));
                B[virus.get(i).x][virus.get(i).y] = 3;
                int time = bfs(q, B);
                answer = Math.min(answer, time);
            }
        } while (permutation(p));

        System.out.println(answer);
    }

    private static int bfs(Queue<Virus> q, int[][] B) {

    }

    private static boolean permutation(int[] p) {
        int N = virus.size();
        int i = N - 1;
        while (i > 0 && p[i - 1] >= p[i]) i--;

        if (i == 0) return false;

        int j = N - 1;
        while (p[i - 1] >= p[j]) j--;

        swap(p, i - 1, j);

        int k = N - 1;
        while (i < k) swap(p, i++, k--);
        return true;
    }

    private static void swap(int[] p, int a, int b) {
        p[a] ^= p[b];
        p[b] ^= p[a];
        p[a] ^= p[b];
    }

    private static class Virus {
        int x, y;
        boolean status;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
            this.status = false;
        }
    }
}
