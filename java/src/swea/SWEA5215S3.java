package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 5215 햄버거 다이어트
// 부분 집합 (메모리: 20,204 kb, 시간: 168 ms)
public class SWEA5215S3 {
    private static int N, L;
    private static Ingredient[] ingredients;
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
            hambuger(0, 0, 0);
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void hambuger(int start, int taste, int kal) {
        if (start >= N) {
            answer = Math.max(answer, taste);
            return;
        }

        if (kal + ingredients[start].kal <= L)
            hambuger(start + 1, taste + ingredients[start].taste, kal + ingredients[start].kal);
        hambuger(start + 1, taste, kal);
    }

    private static class Ingredient {
        private int taste, kal;

        public Ingredient(int taste, int kal) {
            this.taste = taste;
            this.kal = kal;
        }
    }
}
