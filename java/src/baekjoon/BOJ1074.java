package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1074 Z
public class BOJ1074 {
    private static int N, R, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);
        System.out.println(solution(new Point(0, 0), new Point(size - 1, size - 1), N, size * size));
    }

    private static int solution(Point start, Point end, int n, int size) {
        int x = (start.x + end.x) / 2;
        int y = (start.y + end.y) / 2;
        int s = size / 4;

        if (R < x && C < y) {
            return solution(start, new Point(x - 1, y - 1), n - 1, s);
        } else if (R <= x && C > y) {
            return solution(new Point(start.x, y + 1), new Point(x, end.y), n - 1, s * 2);
        } else if (R > x && C <= y) {
            return solution(new Point(x + 1, start.y), new Point(end.x, y), n - 1, s * 3);
        } else if (R > x && C > y) {
            return solution(new Point(x + 1, y + 1), end, n - 1, s * 4);
        } else {
            return size - 1;
        }
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
