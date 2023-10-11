package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class MazeRunner {
    private static int N, M, K;
    private static int[][] maze;
    private static int[][] array;
    private static LinkedList<Point> person;
    private static Point endPoint;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        maze = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        person = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            person.add(new Point(x - 1, y - 1));
        }

        st = new StringTokenizer(br.readLine());
        endPoint = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        answer = 0;
        int time = 0;
        array = new int[N][N];

        while (!person.isEmpty() && time++ < K) {
            move();
            if (person.isEmpty()) {
                break;
            }
            int[] small = findSmallSquare();
            rotation(small[1], small[2], small[0]);
        }

        System.out.println(answer);
        System.out.println((endPoint.x + 1) + " " + (endPoint.y + 1));
    }

    private static int[] findSmallSquare() {
        int r, c, s;
        r = c = s = 0;

        for (int l = 2; l <= N; l++) {
            for (int i = 0; i <= N - l; i++) {
                for (int j = 0; j <= N - l; j++) {
                    if (endPoint.x >= i && endPoint.x < i + l && endPoint.y >= j && endPoint.y < j + l) {

                        boolean exist = false;
                        for (Point p : person) {
                            if (p.x >= i && p.x < i + l && p.y >= j && p.y < j + l) {
                                exist = true;
                                s = l;
                                r = i;
                                c = j;
                                break;
                            }
                        }

                        if (exist) {
                            return new int[]{s, r, c};
                        }
                    }
                }
            }
        }
        return null;
    }

    private static void move() {
        int length = person.size();
        for (int i = 0; i < length; i++) {
            Point p = person.poll();

            boolean success = false;
            if (p.x != endPoint.x) {
                int nx = endPoint.x < p.x ? p.x - 1 : p.x + 1;
                if (maze[nx][p.y] == 0) {
                    answer += 1;
                    p.x = nx;
                    success = true;
                }
            }
            if (!success) {
                if (p.y != endPoint.y) {
                    int ny = endPoint.y < p.y ? p.y - 1 : p.y + 1;
                    if (maze[p.x][ny] == 0) {
                        answer += 1;
                        p.y = ny;
                    }
                }
            }

            if (endPoint.x != p.x || endPoint.y != p.y) {
                person.add(p);
            }
        }
    }

    private static void rotation(int r, int c, int size) {
        // 종료지점 이동
        int x = endPoint.y - c + r;
        int y = size - endPoint.x + r - 1 + c;
        endPoint = new Point(x, y);
        // 범위내 사람들 이동
        for (int i = 0; i < person.size(); i++) {
            Point poll = person.poll();
            if (poll.x >= r && poll.x < r + size && poll.y >= c && poll.y < c + size) {
                x = poll.y - c + r;
                y = size - poll.x + r - 1 + c;
                poll.x = x;
                poll.y = y;
            }
            person.add(poll);
        }

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                array[j - c + r][size - i + r - 1 + c] = maze[i][j];
            }
        }

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                maze[i][j] = array[i][j];
                if (maze[i][j] > 0) maze[i][j] -= 1;
            }
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
