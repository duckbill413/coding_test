package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA5658 {
    public static int N, M;
    public static LinkedHashSet<Integer> result;
    public static void addNumbers(String s, int K) {
        String aString = s.substring(0, K);
        String bString = s.substring(K, K*2);
        String cString = s.substring(K*2, K*3);
        String dString = s.substring(K*3, K*4);
        result.add(Integer.parseInt(aString, 16));
        result.add(Integer.parseInt(bString, 16));
        result.add(Integer.parseInt(cString, 16));
        result.add(Integer.parseInt(dString, 16));
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int K = (int)(N / 4.0);

            st = new StringTokenizer(br.readLine());
            result = new LinkedHashSet<>();
            String s = st.nextToken();
            addNumbers(s,  K);

            for (int i=0; i<N; i++) {
                String tmp = s;
                s = tmp.substring(N-1) + tmp.substring(0, N-1);
                addNumbers(s, K);
            }
            List<Integer> sorted = new ArrayList<>(result);
            Collections.sort(sorted);
            System.out.printf("#%d %d\n", test_case, sorted.get(sorted.size()-M));
        }
    }
}