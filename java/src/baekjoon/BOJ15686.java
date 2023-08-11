package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 15686 치킨 배달 (메모리: 16764kb, 시간: 180ms)
public class BOJ15686 {
    private static List<Point> houses;
    private static List<Point> chicken;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        houses = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    houses.add(new Point(i, j));
                } else if (tmp == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        int[] p = new int[chicken.size()];
        int cnt = 0;
        while (++cnt <= M) p[chicken.size() - cnt] = 1;

        int answer = Integer.MAX_VALUE;
        do {
            int result = 0;
            for (Point house : houses) {
                int dist = Integer.MAX_VALUE;
                for (int i = 0; i < chicken.size(); i++) {
                    if (p[i] == 0) continue;
                    dist = Math.min(dist, getDistance(house, chicken.get(i)));
                }
                result += dist;
            }
            answer = Math.min(answer, result);
        } while (permutation(p));

        System.out.println(answer);
    }

    private static int getDistance(Point house, Point chicken) {
        return Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
    }

    private static boolean permutation(int[] p) {
        int N = p.length;
        int i = N - 1;
        while (i > 0 && p[i - 1] >= p[i]) --i;

        if (i == 0) return false;

        int j = N - 1;
        while (p[i - 1] >= p[j]) --j;

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

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
