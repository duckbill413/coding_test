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
// 17142 연구소3
public class BOJ17142 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int N, M;
    private static List<Virus> virus;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][N];

        virus = new ArrayList<>();
        int empty = 0; // 빈칸의 개수
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == 2) {
                    virus.add(new Virus(i, j));
                } else if (A[i][j] == 0) {
                    empty += 1;
                }
            }
        }

        int[] p = new int[virus.size()];
        int cnt = 0;
        while (++cnt <= M) p[virus.size() - cnt] = 1;

        int answer = Integer.MAX_VALUE;
        do {
            int[][] B = new int[N][N];
            for (int i = 0; i < N; i++) {
                B[i] = Arrays.copyOf(A[i], N);
            }

            Queue<Virus> q = new ArrayDeque<>();
            for (int i = 0; i < virus.size(); i++) {
                if (p[i] == 0) continue;

                q.add(virus.get(i));
                B[virus.get(i).x][virus.get(i).y] = 3;
            }

            answer = Math.min(answer, bfs(q, empty, B));
        } while (permutation(p));

        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    private static int bfs(Queue<Virus> q, int empty, int[][] B) {
        if (empty == 0) return 0;
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Virus cur = q.poll();

                // 빈칸에 바이러스 전파
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (inRange(nx, ny) && B[nx][ny] != 1 && B[nx][ny] != 3) {
                        if (B[nx][ny] == 0) empty -= 1;
                        B[nx][ny] = 3;
                        q.add(new Virus(nx, ny));
                    }
                }
            }
            if (empty != 0) time += 1;
        }
        if (empty == 0) return time + 1;
        else return Integer.MAX_VALUE;
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

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
