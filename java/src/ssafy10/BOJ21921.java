package ssafy10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BOJ21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] people = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] sum = new int[N];
        sum[0] = people[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + people[i];
            if (i >= X) {
                sum[i] -= people[i - X];
            }
        }

        int max = Arrays.stream(sum).max().getAsInt();
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (sum[i] == max) {
                count++;
            }
        }
        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}
