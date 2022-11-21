package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class No3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        int jump = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> jumping = new HashMap<>();
        for (int i = 0; i < jump; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            jumping.put(end, start);
        }

        int[] dp = new int[size];
        for (int i = 1; i < size; i++) {
            if (i > 6) {
                int min = (int) 1e9;
                for (int j=i-6; j<i; j++){
                    if (dp[j] < min){
                        min = dp[j];
                    }
                }
                dp[i] = min+1;
            } else
                dp[i] = 1;

            if (jumping.get(i) != null){
                if (jumping.get(i) < i) {
                    dp[i] = dp[jumping.get(i)];
                }
                else
                    dp[jumping.get(i)] = dp[i];
            }
        }

        System.out.println(dp[size-1]);
    }
}
