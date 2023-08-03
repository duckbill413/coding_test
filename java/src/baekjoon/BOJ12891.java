package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ12891 {
    private static int N, M;
    private static char[] array;
    private static Map<Character, Integer> keys;
    private static int answer;
    private static final char[] key = {'A', 'C', 'G', 'T'};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new char[N];

        String tmp = br.readLine();
        for (int i = 0; i < N; i++) {
            array[i] = tmp.charAt(i);
        }

        st = new StringTokenizer(br.readLine());
        keys = new HashMap<>();

        for (int i = 0; i < key.length; i++) {
            keys.put(key[i], Integer.parseInt(st.nextToken()));
        }
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < N; i++) {
            count.put(array[i], count.getOrDefault(array[i], 0) + 1);

            if (i >= M - 1) {
                boolean find = true;
                for (int k = 0; k < key.length; k++) {
                    if (count.getOrDefault(key[k], 0) < keys.get(key[k])) {
                        find = false;
                        break;
                    }
                }
                if (find) {
                    answer++;
                }

                count.put(array[i - M + 1], count.get(array[i - M + 1]) - 1);
            }
        }

        System.out.println(answer);
    }
}
