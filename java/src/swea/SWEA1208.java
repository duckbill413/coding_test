package swea;

import java.io.*;
import java.util.*;

public class SWEA1208 {
    private static final int T = 10;
    private static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            height = new int[101];

            // 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int h = Integer.parseInt(st.nextToken());
                for (int i = 0; i <= h; i++) {
                    height[i]++;
                }
            }
            // 최저층
            int start = 1;
            // 최고층
            int end = 100;

            while (start < end) {
                if (height[start] == 100) {
                    start++;
                    continue;
                }
                if (height[end] == 0) {
                    end--;
                    continue;
                }

                if (height[start] + height[end] > 100) {
                    int diff = 100 - height[start];
                    if (diff > N) {
                        break;
                    }
                    N -= diff;

                    height[start++] = 100;
                    height[end] -= diff;
                } else {
                    if (height[end] > N) {
                        break;
                    }
                    N -= height[end];
                    height[start] += height[end];
                    height[end--] = 0;
                }
            }

            System.out.println("#" + test_case + " " + (end - start + 1));
        }
    }
}