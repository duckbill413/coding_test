package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

// 12015 가장 긴 증가하는 부분 수열 2
public class BOJ12015 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> result = new ArrayList<>();
        result.add(nums[0]);

        for (int n : nums) {
            if (result.get(result.size() - 1) < n) {
                result.add(n);
            } else {
                int left = 0;
                int right = result.size() - 1;

                while (left < right) {
                    int mid = (left + right) / 2;
                    if (result.get(mid) < n) left = mid + 1;
                    else right = mid;
                }

                result.set(right, n);
            }
        }

        System.out.println(result.size());
    }
}
