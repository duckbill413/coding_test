package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 23884 선택 정렬 4
public class BOJ23884 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        Map<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            array[i] = n;
            index.put(n, i);
        }
        int[] sorted = Arrays.copyOf(array, array.length);
        Arrays.sort(sorted);


        for (int i = N - 1; i > 0; i--) {
            if (array[i] != sorted[i]) {
                int a = array[i];
                int s = sorted[i];

                int tmp = array[i];
                array[i] = array[index.get(sorted[i])];
                array[index.get(sorted[i])] = tmp;

                tmp = index.get(a);
                index.put(a, index.get(s));
                index.put(s, tmp);
                K--;
            }
            if (K == 0) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < N; j++) {
                    sb.append(array[j]).append(" ");
                }
                System.out.println(sb);
                return;
            }
        }
        System.out.println(-1);
    }
}
