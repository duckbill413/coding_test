package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Permutation {
    private static int N, R;
    private static int[] input, numbers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        numbers = new int[R];

        input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        permutation(0, 0);
    }

    private static void permutation(int cnt, int flag) {
        if (cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = 0; i < N; i++) {
            // 중복 체크
            if ((flag & 1 << i) != 0) {
                continue;
            }
            // 수 선택
            numbers[cnt] = input[i];
            // 다음 자리수 뽑기
            permutation(cnt + 1, flag | 1 << i);
        }
    }
}
