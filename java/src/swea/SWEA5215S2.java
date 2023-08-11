package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 5215 햄버거 다이어트
// DP를 이용한 풀이 (메모리: 20,064 kb, 시간: 137ms)
public class SWEA5215S2 {
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
            int[] taste = new int[L + 1];
            for (int n = 0; n < N; n++) {
                for (int l = L; l >= ingredients[n].kal; l--) {
                    taste[l] = Math.max(taste[l], taste[l - ingredients[n].kal] + ingredients[n].taste);
                    answer = Math.max(answer, taste[l]);
                }
            }
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static class Ingredient {
        private int taste, kal;

        public Ingredient(int taste, int kal) {
            this.taste = taste;
            this.kal = kal;
        }
    }
}
