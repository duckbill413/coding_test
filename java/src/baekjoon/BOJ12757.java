package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ12757 {
    private static int N, M, K;
    private static TreeMap<Integer, Integer> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            map.put(key, val);
        }

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int order, key, val, findKey;
            order = Integer.parseInt(st.nextToken());

            switch (order) {
                case 1:
                    key = Integer.parseInt(st.nextToken());
                    val = Integer.parseInt(st.nextToken());
                    map.put(key, val);
                    break;
                case 2:
                    key = Integer.parseInt(st.nextToken());
                    val = Integer.parseInt(st.nextToken());
                    findKey = findKey(key);
                    map.put(findKey, val);
                    break;
                case 3:
                    key = Integer.parseInt(st.nextToken());
                    findKey = findKey(key);
                    if (findKey == -1) sb.append(-1);
                    else if (findKey == -2) sb.append("?");
                    else sb.append(map.get(findKey));
                    sb.append('\n');
            }
        }
        System.out.println(sb);
    }

    private static int findKey(int key) {
        if (map.containsKey(key)) {
            return key;
        }

        Integer left = map.lowerKey(key);
        Integer right = map.higherKey(key);

        int diffA, diffB;
        if (left == null) diffA = 10001;
        else diffA = key - left;
        
        if (right == null) diffB = 10001;
        else diffB = right - key;

        if (diffA == diffB && diffA <= K) {
            return -2;
        }
        if (diffA < diffB && diffA <= K) {
            return left;
        }
        if (diffA > diffB && diffB <= K) {
            return right;
        }
        return -1;
    }
}
