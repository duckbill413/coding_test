package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA3307 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            List<Integer> result = new ArrayList<>();
            result.add(Integer.parseInt(st.nextToken()));
            for (int i = 0; i < N - 1; i++) {
                int num = Integer.parseInt(st.nextToken());

                if (result.get(result.size() - 1) < num) {
                    result.add(num);
                } else {
                    int index = lowerBound(num, result);
                    result.set(index, num);
                }
            }

            sb.append("#").append(test_case).append(" ").append(result.size()).append('\n');
        }
        System.out.println(sb);
    }

    private static int lowerBound(int target, List<Integer> array) {
        int start = 0;
        int end = array.size() - 1;

        while (start < end) {
            int mid = (start + end) / 2;

            if (array.get(mid) >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
