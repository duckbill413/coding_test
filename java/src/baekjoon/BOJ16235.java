package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

// 16235 나무 재테크
public class BOJ16235 {
    private static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    private static int N, M, K;
    private static int[][] map;
    private static Deque<Tree> trees;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        trees = new ArrayDeque<>();

        int[][] A = new int[N + 1][N + 1];
        // 현재 땅의 영양 정보
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }

        // 나무의 정보
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());

            trees.add(new Tree(x, y, age));
        }

        while (K-- > 0) {
            Queue<Tree> deadTree = new ArrayDeque<>();
            // 봄 => 영양분 흡수
            for (int i = 0; i < trees.size(); i++) {
                Tree tree = trees.poll();
                if (map[tree.x][tree.y] >= tree.age) {
                    map[tree.x][tree.y] -= tree.age;
                    tree.age += 1;
                    trees.addLast(tree);
                } else {
                    deadTree.add(tree);
                    i--;
                }
            }
            // 여름 => 죽은 나무 환원
            while (!deadTree.isEmpty()) {
                Tree dead = deadTree.poll();
                map[dead.x][dead.y] += dead.age / 2;
            }
            // 가을 => 나무 번식
            Queue<Tree> newTrees = new ArrayDeque<>();
            for (Tree tree : trees) {
                if (tree.age % 5 == 0) {
                    newTrees.add(tree);
                }
            }
            while (!newTrees.isEmpty()) {
                Tree cur = newTrees.poll();

                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (inRange(nx, ny)) {
                        trees.addFirst(new Tree(nx, ny, 1));
                    }
                }
            }
            // 겨울 => 영양분 보충
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] += A[i][j];
                }
            }
        }
        int answer = trees.size();
        System.out.println(answer);
    }

    private static class Tree implements Comparable<Tree> {
        int x, y, age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= N;
    }
}
