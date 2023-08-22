package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 1759 암호 만들기 (메모리: 18216kb, 시간: 232ms)
public class BOJ1759 {
    private static int L, C;
    private static char[] keys;
    private static boolean[] vowel;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 1. a, e, i, o, u 중 최소 한개
        // 2. and 최소 2개의 자음
        // 3. 알파벳은 암호에서 증가하는 순서로 배열

        keys = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            keys[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(keys);

        // 모음인지 체크
        vowel = new boolean[C];
        for (int i = 0; i < C; i++) {
            if (keys[i] == 'a' || keys[i] == 'e' || keys[i] == 'i' || keys[i] == 'o' || keys[i] == 'u') {
                vowel[i] = true;
            }
        }

        int[] p = new int[C];
        int cnt = 0;
        while (++cnt <= L) p[C - cnt] = 1;

        List<String> answer = new ArrayList<>();
        do {
            int c, v;
            c = v = 0;
            for (int i = 0; i < C; i++) {
                if (p[i] == 0) continue;
                if (vowel[i]) v++;
                else c++;
            }

            StringBuilder sb = new StringBuilder();
            if (c >= 2 && v >= 1) {
                for (int i = 0; i < C; i++) {
                    if (p[i] == 0) continue;
                    sb.append(keys[i]);
                }
                answer.add(sb.toString());
            }
        } while (permutation(p));

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        answer.forEach(s -> sb.append(s).append("\n"));
        System.out.print(sb);
    }

    private static boolean permutation(int[] p) {
        int N = p.length;
        int i = N - 1;
        while (i > 0 && p[i - 1] >= p[i]) i--;

        if (i == 0) return false;

        int j = N - 1;
        while (p[i - 1] >= p[j]) j--;

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
}
