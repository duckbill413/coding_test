package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;

// Next Permutation 함수를 활용한 Combination 구하기
public class CombinationNPT {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] p = new int[N];
        int cnt = 0;
        while (++cnt <= R) p[N - cnt] = 1;

        do {
            // p 배열을 이용한 조합 확인
            for (int i = 0; i < N; i++) {
                if (p[i] == 0) continue;
                System.out.print(input[i] + "\t");
            }
            System.out.println();
        } while (permutation(p));
    }

    /**
     * 1. 맨 뒤쪽부터 탐색하여 꼭대기 찾기
     * 2. 꼭대기 직전 (i-1) 위치에 교환할 한단계 큰 수 찾기
     * 3. 꼭대기 적전 (i-1) 위치의 수와 한단계 큰 수를 교환하기
     * 4. 꼭대기 자리 부터 맨뒤까지의 수를 오름차순의 형태로 바꿈
     *
     * @param p 다음 순열을 원하는 기존 순열의 배열
     */
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
}
