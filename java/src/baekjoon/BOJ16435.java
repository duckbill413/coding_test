package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16435 스네이크버드 (메모리: 11832kb, 시간: 84kb)
public class BOJ16435 {
    private static final int MAX_LENGTH = 10001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] fruits = new int[MAX_LENGTH];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[Integer.parseInt(st.nextToken())]++;
        }

        for (int i = 1; i < MAX_LENGTH; i++) {
            if (fruits[i] > 0 && L >= i) {
                L += fruits[i];
            } else if (L < i) {
                break;
            }
        }

        System.out.println(L);
    }
}
