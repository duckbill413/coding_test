package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 5215 햄버거 다이어트
// 조합을 이용한 풀이 (NPT 사용) (메모리: 25,292 kb, 시간: 1,156 ms)
public class SWEA5215S4 {
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
            for (int r = 1; r <= N; r++) {
                int[] p = new int[N];
                int cnt = 0;
                while (++cnt <= r) p[N - cnt] = 1;

                do {
                    int taste = 0;
                    int kal = 0;
                    for (int i = 0; i < N; i++) {
                        if (p[i] == 0) continue;
                        taste += ingredients[i].taste;
                        kal += ingredients[i].kal;
                        if (kal > L) {
                            break;
                        }
                    }
                    if (kal <= L)
                        answer = Math.max(answer, taste);
                } while (permutation(p));
            }

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean permutation(int[] p) {
        int N = p.length;
        int i = N - 1;
        while (i > 0 && p[i - 1] >= p[i]) --i;

        if (i == 0) return false; // 다음 순열은 없음 (가장 큰 순열의 형태)

        int j = N - 1;
        while (p[i - 1] >= p[j]) --j;

        swap(p, i - 1, j);

        int k = N - 1;
        while (i < k) swap(p, i++, k--);
        return true;
    }

    private static void swap(int[] p, int a, int b) {
        int tmp = p[a];
        p[a] = p[b];
        p[b] = tmp;
    }

    private static class Ingredient {
        private int taste, kal;

        public Ingredient(int taste, int kal) {
            this.taste = taste;
            this.kal = kal;
        }
    }
}
