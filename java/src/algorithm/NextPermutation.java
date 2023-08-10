package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * Next Permutation (nPn (= N!))
 * input의 수을 오름차순 정렬
 * 1. 뒤쪽부터 탐색하며 교환위치 (i - 1) 찾기 (i: 꼭대기)
 * 2. 뒤쪽부터 탐색하며 교환위치 (i - 1)와 교환할 큰 값 위치 (j) 찾기
 * 3. 뒤 위치 값 (i-1, j) 교환
 * 4. 꼭대기위치(i)부터 맨 뒤까지 오름차순 정렬
 */
public class NextPermutation {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(input);
        do {
            System.out.println(Arrays.toString(input));
        } while (permutation(input));
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
        while (i > 0 && p[i - 1] > p[i]) --i;

        if (i == 0) return false; // 다음 순열은 없음 (가장 큰 순열의 형태)

        int j = N - 1;
        while (p[i - 1] >= p[j]) --j;

        swap(p, i - 1, j);

        int k = N - 1;
        while (i < k) {
            swap(p, i++, k--);
        }
        return true;
    }

    private static void swap(int[] p, int a, int b) {
        int tmp = p[a];
        p[a] = p[b];
        p[b] = tmp;
    }
}
