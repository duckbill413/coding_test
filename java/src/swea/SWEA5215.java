package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 5215 햄버거 다이어트 (메모리: 20,832 kb, 시간: 1291ms)
public class SWEA5215 {
    private static int N, L;
    private static Ingredient[] ingredients;
    private static boolean[] exist;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            ingredients = new Ingredient[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int taste = Integer.parseInt(st.nextToken());
                int kal = Integer.parseInt(st.nextToken());
                ingredients[i] = new Ingredient(taste, kal);
            }

            answer = 0;
            exist = new boolean[N];
            for (int count = 1; count <= N; count++) {
                combination(0, 0, count);
            }
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void combination(int start, int depth, int size) {
        if (depth == size) {
            int taste, kal;
            taste = kal = 0;
            for (int i = 0; i < N; i++) {
                if (exist[i]) {
                    taste += ingredients[i].taste;
                    kal += ingredients[i].kal;
                    if (kal > L) {
                        return;
                    }
                }
            }
            answer = Math.max(taste, answer);
            return;
        }

        for (int i = start; i < N; i++) {
            exist[i] = true;
            combination(i + 1, depth + 1, size);
            exist[i] = false;
        }
    }

    private static class Ingredient {
        private int taste, kal;

        public Ingredient(int taste, int kal) {
            this.taste = taste;
            this.kal = kal;
        }
    }
}
