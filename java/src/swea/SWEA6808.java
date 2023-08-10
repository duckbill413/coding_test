package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 6808. 규영이와 인영이의 카드게임 (메모리: 23984kb, 시간: 993ms)
public class SWEA6808 {
    private static int[] A;
    private static int SIZE = 9;
    private static int win, lose;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {
            A = new int[SIZE];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < SIZE; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            // 상대방의 카드로 나올 수 있는 카드
            int[] your = new int[SIZE];
            int index = 0;
            for (int i = 1; i <= SIZE * 2; i++) {
                boolean find = false;
                for (int j = 0; j < SIZE; j++) {
                    if (A[j] == i) {
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    your[index++] = i;
                }
            }

            win = lose = 0;
            // Next Permutation을 이용하여 경우를 구하고 승/패 판별
            Arrays.sort(your);

            do {
                if (battle(your)) win++;
                else lose++;
            } while (nextPermutation(your));

            sb.append("#").append(test_case)
                    .append(" ").append(win).append(" ").append(lose).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean nextPermutation(int[] y) {
        int N = y.length;
        int i = N - 1;

        while (i > 0 && y[i - 1] > y[i]) --i;

        if (i == 0) return false;

        int j = N - 1;
        while (y[i - 1] >= y[j]) --j;

        swap(y, i - 1, j);

        int k = N - 1;
        while (i < k) swap(y, i++, k--);

        return true;
    }

    private static void swap(int[] y, int a, int b) {
        int tmp = y[a];
        y[a] = y[b];
        y[b] = tmp;
    }

    private static boolean battle(int[] y) {
        int a = 0;
        int b = 0;

        for (int i = 0; i < SIZE; i++) {
            int sum = A[i] + y[i];
            if (A[i] > y[i]) {
                a += sum;
            } else if (A[i] < y[i]) {
                b += sum;
            }
        }

        return a > b; // 내가 이기는 경우의 수
    }
}
