package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

// TODO: 테케 확인 필요
public class SWEA5644 {
    private static final int[] dx = {0, 0, 1, 0, -1};
    private static final int[] dy = {0, -1, 0, 1, 0};
    private static int M, N;
    private static int[] A, B;
    private static int a, b;
    private static int[][] location;
    private static List<Battery> batteries;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            A = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            B = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            batteries = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                batteries.add(new Battery(x, y, c, p));
            }

            location = new int[2][];
            location[0] = new int[]{1, 1};
            location[1] = new int[]{10, 10};
            a = 0; // A 충전량
            b = 0; // B 충전량

            List<Battery> chargeA = charge(location[0][0], location[0][1]);
            List<Battery> chargeB = charge(location[1][0], location[1][1]);

            solution(chargeA, chargeB);
            for (int i = 0; i < M; i++) {
                // A 위치 갱신
                location[0][0] += dx[A[i]];
                location[0][1] += dy[A[i]];
                // B 위치 갱신
                location[1][0] += dx[B[i]];
                location[1][1] += dy[B[i]];

                chargeA = charge(location[0][0], location[0][1]);
                chargeB = charge(location[1][0], location[1][1]);

                solution(chargeA, chargeB);
            }

            sb.append("#").append(test_case).append(" ").append(a + b).append("\n");
        }
        System.out.println(sb);
    }

    private static void solution(List<Battery> chargeA, List<Battery> chargeB) {

        if (chargeA.isEmpty() && chargeB.isEmpty()) {
            System.out.println("0 0");
            return;
        }

        if (chargeA.isEmpty()) {
            b += chargeB.stream().mapToInt(value -> value.p).max().getAsInt();
//            System.out.println("0 " + chargeB.stream().mapToInt(value -> value.p).max().getAsInt());
            return;
        }
        if (chargeB.isEmpty()) {
            a += chargeA.stream().mapToInt(value -> value.p).max().getAsInt();
//            System.out.println(chargeA.stream().mapToInt(value -> value.p).max().getAsInt() + " 0");
            return;
        }
        int maxA = 0;
        int maxB = 0;
        for (Battery aBattery : chargeA) {
            for (Battery bBattery : chargeB) {
                if (aBattery == bBattery) {
                    maxA = Math.max(maxA, aBattery.p / 2);
                    maxB = Math.max(maxB, bBattery.p / 2);
                } else {
                    maxA = Math.max(maxA, aBattery.p);
                    maxB = Math.max(maxB, bBattery.p);
                }
            }
        }
        a += maxA;
        b += maxB;
        System.out.println(maxA + " " + maxB);
    }


    private static List<Battery> charge(int x, int y) {
        List<Battery> result = new ArrayList<>();
        for (Battery battery : batteries) {
            if (battery.inRange(x, y)) {
                result.add(battery);
            }
        }
        return result;
    }

    private static class Battery {
        int x, y, c, p;

        public Battery(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }

        public boolean inRange(int x, int y) {
            int range = Math.abs(this.x - x) + Math.abs(this.y - y);
            return range <= this.c;
        }
    }
}
